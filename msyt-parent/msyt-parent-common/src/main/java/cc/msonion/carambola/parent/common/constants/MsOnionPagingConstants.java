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


package cc.msonion.carambola.parent.common.constants;

/**
 * @Title: MsOnionPagingConstants.java
 * @Package: cc.msonion.carambola.parent.common.constants
 * @Description: 分页常量类
 * @Company: 广州市两棵树网络科技有限公司
 * @Author: HeroCao hero-cao@msyc.cc
 * @Date: 2017年2月26日 上午11:47:32
 * @Version: V2.0.0
 * @Modify-by: HeroCao hero-cao@msyc.cc
 * @Modify-date: 2017年2月26日 上午11:47:32
 * @Modify-version: V2.0.0
 * @Modify-description: 新增：分页的页码最大值
 */

/**
 * @ClassName: MsOnionPagingConstants
 * @Description: 分页常量类
 * @Company: 广州市两棵树网络科技有限公司
 * @Author: HeroCao hero-cao@msyc.cc
 * @Date: 2017年2月26日 上午11:47:32
 */
public final class MsOnionPagingConstants {

    private MsOnionPagingConstants() {

    }

    /**
     * 分页的页码最大值，如果超过最大值，那么后面的数据就不显示，或者通过大数据来处理，因为性能问题！！！
     */
    public static final int MS_ONION_PAGING_PAGENUM_MAX_VALUE = Integer.MAX_VALUE / 100;

    /**
     * 分页的页码最小值，为1
     */
    public static final int MS_ONION_PAGING_PAGENUM_MIN_VALUE = 1;

    /**
     * 搜索，分页的页码最小值，from：0
     */
    public static final int MS_ONION_PAGING_FROM_MIN_VALUE = 0;

    /**
     * 搜索，分页的页码最大值，from：Integer.MAX_VALUE / 100
     */
    public static final int MS_ONION_PAGING_FROM_MAX_VALUE = Integer.MAX_VALUE / 100;

    /**
     * 搜索，分页的页码最小值，to：0
     */
    public static final int MS_ONION_PAGING_TO_MIN_VALUE = 0;

    /**
     * 搜索，分页的页码最大值，to：Integer.MAX_VALUE / 100
     */
    public static final int MS_ONION_PAGING_TO_MAX_VALUE = Integer.MAX_VALUE / 100;

    /**
     * 分页的每页容量最大值，为：60，天猫最大为100，京东最大为60
     */
    public static final int MS_ONION_PAGING_PAGESIZE_MAX_VALUE = 60;  // 60

    /**
     * 分页的每页容量最小值，为：5
     */
    public static final int MS_ONION_PAGING_PAGESIZE_MIN_VALUE = 5;  // 5

    /**
     * 分页的每页默认容量，为：10
     */
    public static final int MS_ONION_PAGING_PAGESIZE_DEFAULT_VALUE = 10;  // 10

    ///////////////// queryOne  ### Begin ////////////////////////////////////

    /**
     * 查询一条记录，query one分页，页码，为1
     */
    public static final int MS_ONION_QUERY_ONE_PAGENUM_VALUE = 1;

    /**
     * 查询一条记录，query one分页，每页容量，为1
     */
    public static final int MS_ONION_QUERY_ONE_PAGESIZE_VALUE = 1;

    /**
     * 查询一条记录，query one分页，PageHelper 不查询 count，因为性能低
     */
    public static final boolean MS_ONION_QUERY_ONE_PAGING_IS_COUNT = false;

    //////////////////// queryOne  ### End ////////////////////////////////////

    ///////////////// 随机查询记录  ### Begin ////////////////////////////////////

    /**
     * 随机查询记录，query random 随机查询分页，页码，为1
     */
    public static final int MS_ONION_QUERY_RANDOM_PAGENUM_VALUE = 1;

    /**
     * 随机查询记录，query random 随机查询分页，每页容量，为10
     */
    public static final int MS_ONION_QUERY_RANDOM_PAGESIZE_VALUE = 10;

    /**
     * 随机查询记录，query random随机查询分页，PageHelper 不查询 count，因为性能低
     */
    public static final boolean MS_ONION_QUERY_RANDOM_PAGING_IS_COUNT = false;

    //////////////////// 随机查询记录  ### End ////////////////////////////////////

}
