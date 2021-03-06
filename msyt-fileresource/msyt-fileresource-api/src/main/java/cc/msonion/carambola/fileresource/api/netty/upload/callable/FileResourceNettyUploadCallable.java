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
package cc.msonion.carambola.fileresource.api.netty.upload.callable;

import cc.msonion.carambola.fileresource.api.netty.upload.service.FileResourceService;
import cc.msonion.carambola.parent.interfaces.netty.adapter.MsOnionNettyClientAdapter;
import cc.msonion.carambola.parent.interfaces.netty.callable.MsOnionNettyUploadCallable;
import cc.msonion.carambola.parent.pojo.netty.exchange.MsOnionNettyRequest;
import cc.msonion.carambola.parent.pojo.netty.exchange.MsOnionNettyResponse;

/**
 * @ClassName: MsOnionNettyUtils
 * @Description: Netty回调
 * @Company: 广州市两棵树网络科技有限公司
 * @Author: HeroCao hero-cao@msyc.cc
 * @Date: 2017年5月1日 下午5:32:48
 */
public class FileResourceNettyUploadCallable extends MsOnionNettyUploadCallable<MsOnionNettyResponse, MsOnionNettyRequest, FileResourceService> {

    /**
     * MsOnionNettyUploadCallable
     *
     * @param client     Netty客户端实例对象
     * @param method     SERVICE实现类中方法名称，例如：uploadFile、downloadFile、upload、download
     * @param parameters SERVICE实现类中方法的参数
     */
    public FileResourceNettyUploadCallable(MsOnionNettyClientAdapter client, String method, Object... parameters) {
        super(client, method, parameters);
    }

    /**
     * MsOnionNettyUploadCallable
     *
     * @param messageId  消息Id，如果不设置，默认使用UUID
     * @param client     Netty客户端实例对象
     * @param method     SERVICE实现类中方法名称，例如：uploadFile、downloadFile、upload、download
     * @param parameters SERVICE实现类中方法的参数
     */
    public FileResourceNettyUploadCallable(String messageId, MsOnionNettyClientAdapter client, String method, Object... parameters) {
        super(messageId, client, method, parameters);
    }
}
