/**
 * 广州市两棵树网络科技有限公司版权所有
 * DT Group Technology & commerce Co., LtdAll rights reserved.
 * <p>
 * 广州市两棵树网络科技有限公司，创立于2009年。旗下运营品牌洋葱小姐。
 * 洋葱小姐（Ms.Onion） 下属三大业务模块 [洋葱海外仓] , [洋葱DSP] , [洋葱海外聚合供应链]
 * [洋葱海外仓]（DFS）系中国海关批准的跨境电商自营平台(Cross-border ecommerce platform)，
 * 合法持有海外直邮保税模式的跨境电商营运资格。是渠道拓展，平台营运，渠道营运管理，及客户服务等前端业务模块。
 * [洋葱DSP]（DSP）系拥有1.3亿消费者大数据分析模型。 是基于客户的消费行为，消费轨迹，及多维度云算法(MDPP)
 * 沉淀而成的精准消费者模型。洋葱DSP能同时为超过36种各行业店铺 及200万个销售端口
 * 进行多店铺高精度配货，并能预判消费者购物需求进行精准推送。同时为洋葱供应链提供更前瞻的商品采买需求模型 。
 * [洋葱海外聚合供应链]（Super Supply Chain）由中国最大的进口贸易集团共同
 * 合资成立，拥有20余年的海外供应链营运经验。并已入股多家海外贸易企业，与欧美澳等9家顶级全球供应商达成战略合作伙伴关系。
 * 目前拥有835个国际品牌直接采买权，12万个单品的商品供应库。并已建设6大海外直邮仓库，为国内客户提供海外商品采买集货供应，
 * 跨境 物流，保税清关三合一的一体化模型。目前是中国唯一多模式聚合的海外商品供应链 。
 * <p>
 * 洋葱商城：http://m.msyc.cc/wx/indexView?tmn=1
 * <p>
 * 洋桃商城：http://www.yunyangtao.com
 */


package cc.msonion.carambola.system.service.impl;

/**
 * @Title: SysDataDictionaryServiceImpl.java
 * @Package: cc.msonion.carambola.system.service.impl
 * @Description: 数据字典服务实现类
 * @Company: 广州市两棵树网络科技有限公司
 * @Author: liaoxf
 * @Date: 2017年04月24日
 * @Version: V2.0.0
 * @Modify-by: liaoxf
 * @Modify-date: 2017年04月24日
 * @Modify-version: V2.0.0
 * @Modify-description:
 */

import cc.msonion.carambola.parent.ext.constants.MsOnionZookeeperConstants;
import cc.msonion.carambola.commons.common.enums.MsOnionTableRecordStatus;
import cc.msonion.carambola.parent.ext.utils.zookeeper.MsOnionDistributedAtomicLongUtils;
import cc.msonion.carambola.parent.common.constants.MsOnionStatusConstants;
import cc.msonion.carambola.parent.common.exception.MsOnionException;
import cc.msonion.carambola.parent.common.exception.MsOnionIllegalArgumentException;
import cc.msonion.carambola.parent.common.utils.MsOnionCollectionUtils;
import cc.msonion.carambola.parent.ext.service.MsOnionServiceExt;
import cc.msonion.carambola.parent.pojo.MsOnionApiVersion;
import cc.msonion.carambola.parent.pojo.MsOnionResult;
import cc.msonion.carambola.parent.service.validator.MsOnionPojoValidatorUtils;
import cc.msonion.carambola.system.common.SystemMessageConstants;
import cc.msonion.carambola.system.pojo.SysDataDictionary;
import cc.msonion.carambola.system.pojo.SysDataDictionaryExample;
import cc.msonion.carambola.system.service.SysDataDictionaryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName: SysDataDictionaryServiceImpl
 * @Description: 数据字典服务实现类
 * @Company: 广州市两棵树网络科技有限公司
 * @Author: liaoxf
 * @Date: 2017年04月24日
 */
@Service
public class SysDataDictionaryServiceImpl extends MsOnionServiceExt<SysDataDictionary, SysDataDictionaryExample> implements SysDataDictionaryService {


    private static final long serialVersionUID = -5171616377159443789L;

    @Override
    public MsOnionResult saveOrUpdate(MsOnionApiVersion apiVersion,
                                      SysDataDictionary sysDataDictionary) throws MsOnionIllegalArgumentException, MsOnionException {
        try {
            if (null == sysDataDictionary) {
                return MsOnionResult.build(MsOnionStatusConstants.STATUS_400, SystemMessageConstants.POJO_NOT_NULL);
            }

            if (sysDataDictionary.getIdx() == null) {
                // add
                sysDataDictionary.setStatus(MsOnionTableRecordStatus.NORMAL.getValue());
                String valiateMsg = MsOnionPojoValidatorUtils.validatePojo(sysDataDictionary);
                if (StringUtils.isNotEmpty(valiateMsg)) {
                    return MsOnionResult.build(MsOnionStatusConstants.STATUS_400, valiateMsg);
                }

                // 生成Idx
                long idx = MsOnionDistributedAtomicLongUtils.getIdx(this.getMsOnionDomain(), this.getMsOnionCuratorZookeeperClient(),
                        this.getRetryPolicy(), MsOnionZookeeperConstants.ZK_COUNTER_SYSTEM_DICT_IDX_PATH);

                sysDataDictionary.setIdx(idx);

                Long version = MsOnionDistributedAtomicLongUtils.getVersion(this.getMsOnionDomain(), this.getMsOnionCuratorZookeeperClient(),
                        this.getRetryPolicy(), MsOnionZookeeperConstants.ZK_COUNTER_SYSTEM_DICT_VERSION_IDX_PATH);
                sysDataDictionary.setVersion(version);

                int result = this.save(apiVersion, sysDataDictionary);
                if (result > 0) {
                    this.getMsOnionLogger().info(this.getClass().getName(), "## 数据字典新增成功, idx = " + idx);
                    return MsOnionResult.ok();
                }
            } else {
                // update
                String valiateMsg = MsOnionPojoValidatorUtils.validatePojo(sysDataDictionary);
                if (StringUtils.isNotEmpty(valiateMsg)) {
                    return MsOnionResult.build(MsOnionStatusConstants.STATUS_400, valiateMsg);
                }
                SysDataDictionary dictionary = this.queryByPrimaryKey(apiVersion, sysDataDictionary.getIdx());
                // 这些属性排除不需要copy
                String[] excludeArr = new String[]{SystemMessageConstants.IDX, SystemMessageConstants.IDX_CODE,
                        SystemMessageConstants.CREATE_BY_MEMBER_IDX, SystemMessageConstants.CREATE_TIME,
                        SystemMessageConstants.VERSION, SystemMessageConstants.STATUS, SystemMessageConstants.DICT_CODE};
                BeanUtils.copyProperties(sysDataDictionary, dictionary, excludeArr);

                int result = this.updateByPrimaryKey(apiVersion, dictionary);
                if (result > 0) {
                    this.getMsOnionLogger().info(this.getClass().getName(), "## 数据字典更新成功, idx = " + dictionary.getIdx());
                    return MsOnionResult.ok();
                }
            }
            return MsOnionResult.build(MsOnionStatusConstants.STATUS_400, SystemMessageConstants.FAIL);
        } catch (Exception e) {
            throw new MsOnionException(e);
        }
    }

    @Override
    public Map getDictMap(MsOnionApiVersion apiVersion, String dictCode) throws MsOnionIllegalArgumentException, MsOnionException {
        try {
            if (StringUtils.isBlank(dictCode)) {
                return new HashMap();
            }
            SysDataDictionaryExample example = new  SysDataDictionaryExample();
            SysDataDictionaryExample.Criteria criteria = example.createCriteria();
            criteria.andStatusEqualTo(MsOnionTableRecordStatus.NORMAL.getValue());
            criteria.andDictCodeEqualTo(dictCode.trim());
            example.setOrderByClause("zindex asc");
            List<SysDataDictionary> list =  queryByExample(apiVersion, example);
            if (MsOnionCollectionUtils.isEmpty(list)) {
                return new HashMap();
            }
            Map map = new LinkedHashMap(list.size());
            for (SysDataDictionary dict:list) {
                map.put(dict.getDictKey(), dict.getDictValue());
            }
            return map;
        } catch (Exception e) {
            throw new MsOnionException(e);
        }
    }
}
