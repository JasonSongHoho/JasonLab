package lab.xhsdebug;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Jason/XiaoJie
 * @date 2021/6/5
 */
@Data
@JSONType(naming = PropertyNamingStrategy.SnakeCase)
public class MediaFilterInfo {
    static String filterMsg = "[{\"filter_info\":[{\"filters\":[{\"strength\":0.7,\"category_weight\":28,\"use_count_desc\":\"382.8万人使用\",\"use_count\":3827535,\"update_time\":1618216216,\"category_id\":\"自拍\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/0df043483b158285f4cb0041026975eef3c9c5ae\",\"en_name\":\"S2\",\"id\":\"372c0c54276649e282e73fc95c551ac5\",\"filter_url\":\"https://dc.xhscdn.com/8fa4bf71ef906f9e63136483389e3054923fde74/zr.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/c65e314b449ad4ef460a3966e43bfc97076cb075\",\"cover_url\":\"https://picasso-static.xiaohongshu.com/fe-platfrom/aab4c5e7a4816eb3d223dff1c1ab82d1a4365449/portrait_one.png\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"\",\"special_effect_image\":\"\",\"source_type\":4,\"entrance_name\":\"\",\"cn_name\":\"自然\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/athena-legacy/79deccf03fe35789996d9e06b401fccca282f03f\"],\"cover_name\":\"人像1\",\"show_process_bar\":1,\"md5\":\"97a08e6712f0ef68da96eef2df4180ba\",\"desc\":\"原生自然肤质\"},{\"strength\":0.7,\"category_weight\":28,\"use_count_desc\":\"224.5万人使用\",\"use_count\":2244713,\"update_time\":1618216203,\"category_id\":\"自拍\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/0df043483b158285f4cb0041026975eef3c9c5ae\",\"en_name\":\"S1\",\"id\":\"2a5c53fdaed34c6bbb62488c82e9bca4\",\"filter_url\":\"https://dc.xhscdn.com/9a1afaf8fb7934fed6af2721f0afff26f0adbf4b/yuansheng.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/c0aa6133b461439707374d6cc1003015eb00123a\",\"cover_url\":\"https://picasso-static.xiaohongshu.com/fe-platfrom/ca9c9b80a36231a4d4fe2a86cce832d9de63b9c4/portrait_two.png\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"\",\"special_effect_image\":\"\",\"source_type\":4,\"entrance_name\":\"\",\"cn_name\":\"原生\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/athena-legacy/3286f562b49794b4ee791743b565a0928e6efb60\"],\"cover_name\":\"人像2\",\"show_process_bar\":1,\"md5\":\"58d7bcc56cf4b3dd88645b09c48cf2e0\",\"desc\":\"天然高级色彩还原\"},{\"strength\":0.7,\"category_weight\":28,\"use_count_desc\":\"295.5万人使用\",\"use_count\":2955061,\"update_time\":1618216342,\"category_id\":\"自拍\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/0df043483b158285f4cb0041026975eef3c9c5ae\",\"en_name\":\"S5\",\"id\":\"e7f01a58c06b48fda0cce6be7bc78eae\",\"filter_url\":\"https://dc.xhscdn.com/814d76b831140141ada6d9be04a4304c1a22408d/liancang01.png\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/52061525e7e0d2436cb430aa5198eeaec074c835\",\"cover_url\":\"https://picasso-static.xiaohongshu.com/fe-platfrom/a7f66654ba0f2285906ac73b818b93432be0d56c/portrait_three.png\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/600e72c904b7c90001c6e3bf.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"\",\"special_effect_image\":\"\",\"source_type\":2,\"entrance_name\":\"\",\"cn_name\":\"镰仓\",\"user_id\":\"59f985684eacab1ce3cc5409\",\"nick_name\":\"小红书REDesign\",\"example_image\":[\"https://ci.xiaohongshu.com/athena-legacy/ea117d61d977f92072913dbb6a70196f9c5c2a31\"],\"cover_name\":\"人像3\",\"show_process_bar\":1,\"md5\":\"bde6e6cafd534d08b3e58f6c84bfbc07\",\"desc\":\"高校前的晴天海景，一秒人像亮肤的秘密\"}],\"sub_type\":\"人像\"},{\"filters\":[{\"strength\":0.8,\"category_weight\":26,\"use_count_desc\":\"20.8万人使用\",\"use_count\":208260,\"update_time\":1618048546,\"category_id\":\"食欲\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/bff4225b072ed180899c55a1192c4a1087529a65\",\"en_name\":\"F4\",\"id\":\"66c39998600a4aad8f52bacf7cc226c7\",\"filter_url\":\"https://dc.xhscdn.com/e516bced9c428df485ea4a0bb09b554b6521f562/zc.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/3d3cc8df6d393361187f62fcc303125f4197fc7b\",\"cover_url\":\"https://picasso-static.xiaohongshu.com/fe-platfrom/37e60f159357ea0bb7bf7d161259925706219556/fineFood_one.png\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"\",\"special_effect_image\":\"\",\"source_type\":4,\"entrance_name\":\"\",\"cn_name\":\"火锅\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/c3cf74fb89e270b929b3948c1b7d58b0c0707f06\"],\"cover_name\":\"美食1\",\"show_process_bar\":1,\"md5\":\"68f9476d4a89da9519d6147a3ab5f884\",\"desc\":\"暖色调食欲倍增\"},{\"strength\":0.8,\"category_weight\":26,\"use_count_desc\":\"16.2万人使用\",\"use_count\":161670,\"update_time\":1618048521,\"category_id\":\"食欲\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/bff4225b072ed180899c55a1192c4a1087529a65\",\"en_name\":\"F1\",\"id\":\"a874f614fe3f4684b50c4b9f8142aa2b\",\"filter_url\":\"https://fe-video-qc.xhscdn.com/athena-legacy/e1842d2ee4fe923dbabdddce582b5903dab4fbf6/haoweidao.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/6d72265797c9861059e722172f416d4e1dc0af1a\",\"cover_url\":\"https://picasso-static.xiaohongshu.com/fe-platfrom/3023db586f62c6ac38e445af41f6a46c5248a070/fineFood_two.png\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"\",\"special_effect_image\":\"\",\"source_type\":4,\"entrance_name\":\"好味滤镜\",\"cn_name\":\"好味\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/athena-legacy/b801e4337ca68e13fd42bc30692bf919edfc773e\"],\"cover_name\":\"美食2\",\"show_process_bar\":1,\"md5\":\"7856e49b151dab065934373434ec7e61\",\"desc\":\"让美食看起来更加明亮通透\"},{\"strength\":0.8,\"category_weight\":26,\"use_count_desc\":\"12.0万人使用\",\"use_count\":119539,\"update_time\":1618048534,\"category_id\":\"食欲\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/bff4225b072ed180899c55a1192c4a1087529a65\",\"en_name\":\"F3\",\"id\":\"4757462d5acd4298908eb9bfacd3b4a0\",\"filter_url\":\"https://dc.xhscdn.com/f03c9ea6f9db934e15278f189c0668a4168c0927/xc.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/2dd398879b0fc4c7ecbc235f2bbb3c12b3bbc4cf\",\"cover_url\":\"https://picasso-static.xiaohongshu.com/fe-platfrom/712800cda763597339590eaa92c24b01f450b478/fineFood_three.png\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"\",\"special_effect_image\":\"\",\"source_type\":4,\"entrance_name\":\"\",\"cn_name\":\"西餐\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/194b9a06b1475e12f805e2231745fc8e9e8b865f\"],\"cover_name\":\"美食3\",\"show_process_bar\":1,\"md5\":\"9800df5dbf60d8da283de747e99fa1f7\",\"desc\":\"高格调西餐氛围\"}],\"sub_type\":\"美食\"},{\"filters\":[{\"strength\":1.0,\"category_weight\":12,\"use_count_desc\":\"4.4万人使用\",\"use_count\":44440,\"update_time\":1618048591,\"category_id\":\"穿搭\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/038acf8957371afdedcc866af8b0facdd3e6fff0\",\"en_name\":\"O3\",\"id\":\"9af3d865d8c7434281ccfe996565a1be\",\"filter_url\":\"https://fe-video-qc.xhscdn.com/athena-legacy/87fd5102257ab34281e08678bc25470cfbe27e59/jiepai.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/01f16d97a4739a58dbfd54d5dcd8ec8086fd8166\",\"cover_url\":\"https://picasso-static.xiaohongshu.com/fe-platfrom/d0a35c324ec0076b6c2c8bc145b2c58e27101ac6/attire_one.png\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"\",\"special_effect_image\":\"\",\"source_type\":4,\"entrance_name\":\"街拍滤镜\",\"cn_name\":\"街拍\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/athena-legacy/fc468f0b045b6446fc326d178dcc71a226118d25\"],\"cover_name\":\"穿搭1\",\"show_process_bar\":1,\"md5\":\"c47d4a90f54482a3221bc5c1ac4d15aa\",\"desc\":\"时尚KOL街拍场景穿搭色调\"},{\"strength\":1.0,\"category_weight\":12,\"use_count_desc\":\"4.6万人使用\",\"use_count\":45880,\"update_time\":1618048581,\"category_id\":\"穿搭\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/038acf8957371afdedcc866af8b0facdd3e6fff0\",\"en_name\":\"O1\",\"id\":\"be2195da200e46188116ccb124da19cc\",\"filter_url\":\"https://fe-video-qc.xhscdn.com/athena-legacy/b9484030ceae7cf92fc574c959ce06d61c276394/xiuxian.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/0988d2913c9af046d8aa66bf87a05934be73e56f\",\"cover_url\":\"https://picasso-static.xiaohongshu.com/fe-platfrom/e902c574248aec953d3e703173e594ce4cb2ca8a/attire_two.png\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"\",\"special_effect_image\":\"\",\"source_type\":4,\"entrance_name\":\"休闲滤镜\",\"cn_name\":\"休闲\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/athena-legacy/838a54b1e4a27770117d045e42e65d0afd849fff\"],\"cover_name\":\"穿搭2\",\"show_process_bar\":1,\"md5\":\"baef8c3df39e2367fc40c06894758b21\",\"desc\":\"日常休闲风、通勤风穿搭色调\"},{\"strength\":1.0,\"category_weight\":12,\"use_count_desc\":\"2.2万人使用\",\"use_count\":21651,\"update_time\":1618048586,\"category_id\":\"穿搭\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/038acf8957371afdedcc866af8b0facdd3e6fff0\",\"en_name\":\"O2\",\"id\":\"2421f16dabb549a1b3ce6aca277d38c3\",\"filter_url\":\"https://fe-video-qc.xhscdn.com/athena-legacy/3f9b9157af397b8f883c9404865c4250288258c5/jijian.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/e4e203444c2381ab5cdedd6ca0a38f56872fda91\",\"cover_url\":\"https://picasso-static.xiaohongshu.com/fe-platfrom/172d023d722c969c782d21ecc0567d20e8681ffd/attire_three.png\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"\",\"special_effect_image\":\"\",\"source_type\":4,\"entrance_name\":\"极简滤镜\",\"cn_name\":\"极简\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/athena-legacy/c0f59f963a170023a9feaa1a13a9fad4aad693e3\"],\"cover_name\":\"穿搭3\",\"show_process_bar\":1,\"md5\":\"b4d6c5b2edb4f110f27dc96aad2a749c\",\"desc\":\"黑白灰色系服装穿搭色调\"}],\"sub_type\":\"穿搭\"},{\"filters\":[{\"strength\":0.8,\"category_weight\":7,\"use_count_desc\":\"13.1万人使用\",\"use_count\":131287,\"update_time\":1618048665,\"category_id\":\"电影\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/a74e47d910ed541b74c341872d131da178ff5c7f\",\"en_name\":\"M2\",\"id\":\"265a731adf2349e89f78fa7937ea3b75\",\"filter_url\":\"https://dc.xhscdn.com/99262f783e87fa5c91a35d44a0e529215de907e5/ms.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/d9b6a712cf608422d2fea27fbe1e7bbb38295fea\",\"cover_url\":\"https://picasso-static.xiaohongshu.com/fe-platfrom/f1b8eec26a644003941f02f9647f3d449db3e761/film_one.png\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"\",\"special_effect_image\":\"\",\"source_type\":4,\"entrance_name\":\"\",\"cn_name\":\"加州公路\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/f6b941864c2bfbebffab6cdbbe70fced855160c1\"],\"cover_name\":\"胶片1\",\"show_process_bar\":1,\"md5\":\"1e40f9fa8899e6cdc1181eb30b7393db\",\"desc\":\"美式公路电影感\"},{\"strength\":0.8,\"category_weight\":7,\"use_count_desc\":\"11.1万人使用\",\"use_count\":110509,\"update_time\":1618048671,\"category_id\":\"电影\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/a74e47d910ed541b74c341872d131da178ff5c7f\",\"en_name\":\"M3\",\"id\":\"910cfb1e02d142d483ad795e652c1955\",\"filter_url\":\"https://dc.xhscdn.com/15f240c23be454eb9fe1edfd5d229274e0a6de28/xg.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/a258026d96931045f042e951f9373be82ffb4dc4\",\"cover_url\":\"https://picasso-static.xiaohongshu.com/fe-platfrom/1684063c7ce603c069357a631bf8c5818d99a498/film_two.png\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"\",\"special_effect_image\":\"\",\"source_type\":4,\"entrance_name\":\"\",\"cn_name\":\"春光乍泄\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/6bb9b6035c7b649c7a802757dd803dddd68fc4fe\"],\"cover_name\":\"胶片2\",\"show_process_bar\":1,\"md5\":\"e9d0fb1f50a46a5ff7c4336ad1af9a5d\",\"desc\":\"复古港风电影感\"},{\"strength\":0.8,\"category_weight\":7,\"use_count_desc\":\"9.5万人使用\",\"use_count\":94620,\"update_time\":1618048659,\"category_id\":\"电影\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/a74e47d910ed541b74c341872d131da178ff5c7f\",\"en_name\":\"M1\",\"id\":\"9349a68698b8481fb753187a0c9e3fa1\",\"filter_url\":\"https://dc.xhscdn.com/ad56fdee4a35c81846317893b595eb634cd1fe3e/xd.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/0b4b31cfa2cde9a7ac5fd3b39b0f44ebc69af4eb\",\"cover_url\":\"https://picasso-static.xiaohongshu.com/fe-platfrom/fadb9441fb4c0e7166a5129404175d7e5a0a2344/film_three.png\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"\",\"special_effect_image\":\"\",\"source_type\":4,\"entrance_name\":\"\",\"cn_name\":\"摩登黑金\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/bae4349e1a348fc8f0a6261faf17025f9bfb4a71\"],\"cover_name\":\"胶片3\",\"show_process_bar\":1,\"md5\":\"a106f368b4b5898f80e03360772f3d9d\",\"desc\":\"建筑街景黑金风\"}],\"sub_type\":\"胶片\"},{\"filters\":[{\"strength\":0.7,\"category_weight\":23,\"use_count_desc\":\"62.2万人使用\",\"use_count\":622219,\"update_time\":1618048727,\"category_id\":\"探店\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/5262c0b466129504cb066e936b0d5b7a71e270e3\",\"en_name\":\"V3\",\"id\":\"5c9e0b055f5348c1a4007559acd5c417\",\"filter_url\":\"https://dc.xhscdn.com/8047ec1fe9100795e3ed33587c58f77cf25e6950/ml.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/5fda85428ef5d6799ed932d09201040472176dc4\",\"cover_url\":\"https://picasso-static.xiaohongshu.com/fe-platfrom/cbcccaf999b8a4b3b361bda36cdff5eca67f2be9/japanStyle_one.png\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"\",\"special_effect_image\":\"\",\"source_type\":4,\"entrance_name\":\"\",\"cn_name\":\"清晰\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/5e0713a885a384d7fc08f7ba3fc4a297a712291f\"],\"cover_name\":\"日系1\",\"show_process_bar\":1,\"md5\":\"46ef04b0b25749a14a6b7ac420267515\",\"desc\":\"明亮通透更清晰\"},{\"strength\":0.8,\"category_weight\":26,\"use_count_desc\":\"12.9万人使用\",\"use_count\":128790,\"update_time\":1618048552,\"category_id\":\"食欲\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/bff4225b072ed180899c55a1192c4a1087529a65\",\"en_name\":\"F5\",\"id\":\"e1da1805a62a4c8391f14976c5674b34\",\"filter_url\":\"https://dc.xhscdn.com/98ec272b1cf314892dc4ae8cc37f16b75be79b7a/xwc.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/64a50f7a9ceb48b149a0722dc9495990c6c0c06d\",\"cover_url\":\"https://picasso-static.xiaohongshu.com/fe-platfrom/baf2a72bb398b89b31c21192c679ec13e1f9fd74/japanStyle_two.png\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"\",\"special_effect_image\":\"\",\"source_type\":4,\"entrance_name\":\"\",\"cn_name\":\"茶点\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/301328f55f2ba87fb7c050a6b044e8f2f2f85d16\"],\"cover_name\":\"日系2\",\"show_process_bar\":1,\"md5\":\"4f72c7485994ab90e6e49ad4ff656a31\",\"desc\":\"日系杂志下午茶\"},{\"strength\":0.7,\"category_weight\":23,\"use_count_desc\":\"127.0万人使用\",\"use_count\":1270017,\"update_time\":1618048733,\"category_id\":\"探店\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/5262c0b466129504cb066e936b0d5b7a71e270e3\",\"en_name\":\"V4\",\"id\":\"4865d8aaee3949b9b5f8459af38de39b\",\"filter_url\":\"https://dc.xhscdn.com/f3f572131c9bad2153b70ca718b1de7f0fdc83c6/Ganjin.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/e3766722761f864c4caf965807715ef8098cc608\",\"cover_url\":\"https://picasso-static.xiaohongshu.com/fe-platfrom/80ad31ade556a7641125617e75ef6373b677f001/japanStyle_three.png\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5c331c97c8828700011b4370.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"\",\"special_effect_image\":\"\",\"source_type\":4,\"entrance_name\":\"\",\"cn_name\":\"干净奶白\",\"user_id\":\"5c331bfb000000000601ae63\",\"nick_name\":\"RED Studio\",\"example_image\":[\"https://ci.xiaohongshu.com/athena-legacy/64474968059daaac267630f22295721c5fc0e720\",\"https://ci.xiaohongshu.com/athena-legacy/1fefe2270ea89424f4bae8d4865f006c20d2d465\"],\"cover_name\":\"日系3\",\"show_process_bar\":1,\"md5\":\"9a5149cbbd9446a56fe85deb343aa626\",\"desc\":\"适合大片白色/干净的画面\"}],\"sub_type\":\"日系\"}],\"type\":\"静态\"},{\"filter_info\":[{\"filters\":[{\"strength\":0.7,\"category_weight\":1,\"use_count_desc\":\"17.2万人使用\",\"use_count\":172255,\"update_time\":1618544359,\"category_id\":\"动态\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/f4cd4bc611c57f8a567eba6fa4257fba42ba8d71\",\"en_name\":\"Golden Powder\",\"id\":\"b7615600e04d4b3fb00364c55e911cdd\",\"filter_url\":\"https://fe-video-qc.xhscdn.com/athena-legacy/977953f7b4c7d38350fd90e6fbb361e45807056d/jinfen_0201.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/02019c96d65e241fd2231a884a189b62efac6879\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/1e97151dd736548302f63f848bb1b5a6a2f5dbf5/jinfenshiyi_02_00000_iSpt.gif\",\"special_effect_image\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/26858c33fb70fdd67b9fa134e8c68ea6ec793b58/jinfenshiyi_02_00000_iSpt.gif\",\"source_type\":5,\"entrance_name\":\"金粉滤镜\",\"cn_name\":\"金粉\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/athena-legacy/ee7d626318dec3b9869b85d16d7825c6b055b846\"],\"show_process_bar\":1,\"md5\":\"d05f6bd19adfb2c33581adcd88bdafd1\",\"desc\":\"一起感受新年金色粉墨！\"},{\"strength\":1.0,\"category_weight\":1,\"use_count_desc\":\"15.1万人使用\",\"use_count\":151268,\"update_time\":1618557370,\"category_id\":\"动态\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/f4cd4bc611c57f8a567eba6fa4257fba42ba8d71\",\"en_name\":\"M6\",\"id\":\"635dc16426814d0287baae7166df3482\",\"filter_url\":\"https://fe-video-qc.xhscdn.com/athena-legacy/7122b43af8e8287997d7c0f8060c0f2b3a7a9f35/hanabi1.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/a9a16b8cf3dd69aef6143d22f27c4e71f076137f\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/4f0c30857e604ecf5d0d989d8bcd5e03765bd24d/shuanglielanman_iSpt.webp\",\"special_effect_image\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/368926b27b4d871f63bbdd67e0bb29427afe2fce/suolue_lanman_iSpt.webp\",\"source_type\":5,\"entrance_name\":\"烂漫滤镜\",\"cn_name\":\"烂漫\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/athena-legacy/967921d98251e1e621d0534b345faf6653eea7a3\",\"https://ci.xiaohongshu.com/athena-legacy/bc7289aeeb7cef6059be914bbcb46ec1c8618c24\"],\"show_process_bar\":1,\"md5\":\"68711260e78e577da6d3767c3f6a95e3\",\"desc\":\"快用它来装饰跨年瞬间，开启美好一年吧！\",\"topic_info\":{\"page_id\":\"5fe6e1e62979d30001103f6c\",\"link\":\"https://www.xiaohongshu.com/page/topics/5fe6e1e62979d30001103f6c?naviHidden=yes&autoPlayMedioBack=yes\",\"name\":\"再见2020，你好2021\",\"id\":\"5fe6e1d6000000000101d3c1\"}},{\"strength\":0.7,\"category_weight\":1,\"use_count_desc\":\"13.4万人使用\",\"use_count\":133629,\"update_time\":1618557639,\"category_id\":\"动态\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/f4cd4bc611c57f8a567eba6fa4257fba42ba8d71\",\"en_name\":\"M7\",\"id\":\"b4e69883af50454ba8d7593a48a20daf\",\"filter_url\":\"https://fe-video-qc.xhscdn.com/athena-legacy/1ee6f7356146f50ab8f239bdae0f1c740d91b1a8/Radiant20.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/b3ee013b99fe648ddb0dc54d0a2e99f8ee9f80e6\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/565312aa585fa0713527b5eb42289d68c531ede9/huhuhuwarm.webp\",\"special_effect_image\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/9106dbd2360cf7158ee75b9c7c8548126a7ad8e2/warmsun_iSpt.webp\",\"source_type\":5,\"entrance_name\":\"和煦滤镜\",\"cn_name\":\"和煦\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/athena-legacy/65837f157e18d2c02e30fa565a8078cc5e8a5418\"],\"show_process_bar\":1,\"md5\":\"a50c95fe11bd981ee4b17ca50aa80646\",\"desc\":\"和煦的浪漫光斑，适用于探店、自拍哦！\",\"topic_info\":{\"page_id\":\"5fe6e1e62979d30001103f6c\",\"link\":\"https://www.xiaohongshu.com/page/topics/5fe6e1e62979d30001103f6c?naviHidden=yes&autoPlayMedioBack=yes\",\"name\":\"再见2020，你好2021\",\"id\":\"5fe6e1d6000000000101d3c1\"}},{\"strength\":1.0,\"category_weight\":1,\"use_count_desc\":\"1973.4万人使用\",\"use_count\":19734415,\"update_time\":1618557864,\"category_id\":\"动态\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/f4cd4bc611c57f8a567eba6fa4257fba42ba8d71\",\"en_name\":\"M8\",\"id\":\"46a614bee0fd47b5b068d4bc0bb2f576\",\"filter_url\":\"https://dc.xhscdn.com/fc5b1c6c5dd22e23438d829f81500ed01dc1d564/blingbling011916.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/de62fe6d25587d4281c42c62597f74225cfc97c6\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/310c70e62607315259d18fd48e0c1160a71a50e2/xingguangshare.webp\",\"special_effect_image\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/65f5b9e853549bf018772ec964b59313751ede12/xingguangyulan.webp\",\"source_type\":5,\"entrance_name\":\"星光闪闪特效\",\"cn_name\":\"星光闪闪\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/athena-legacy/43eef297719e4c1d06ec2e86290d1d953c023491\"],\"show_process_bar\":0,\"md5\":\"9edaaa27937e6e0e0eb9bc40b0c2d2b2\",\"desc\":\"适合自拍、穿搭，闪闪惹人爱！\"},{\"strength\":1.0,\"category_weight\":1,\"use_count_desc\":\"372.0万人使用\",\"use_count\":3720022,\"update_time\":1618558024,\"category_id\":\"动态\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/f4cd4bc611c57f8a567eba6fa4257fba42ba8d71\",\"en_name\":\"M9\",\"id\":\"512dd6fbd7c0493eb6e2fbb5655d3df7\",\"filter_url\":\"https://dc.xhscdn.com/f970600ac20317c6e63f44cbeec87288c2272b76/xinghe0730.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/9ee857cfee6898268ffc1981f8b119279c935fbd\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/02634d62a6a7dc3e7c6950109549731a0b8bec29/shuanglietu.webp\",\"special_effect_image\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/61ceb0d59ea5a208c035e013007315cbeafb1c8b/fuceng.webp\",\"source_type\":5,\"entrance_name\":\"星河滤镜\",\"cn_name\":\"星河\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/athena-legacy/0118b5be8160a85f8dd5f8e2ab796216f34f7432\"],\"show_process_bar\":0,\"md5\":\"20167e4a46022c4ef389c650bede9ec3\",\"desc\":\"适合天空、人像、户外等场景\",\"topic_info\":{\"page_id\":\"5cc80d19eb1c030001c1acba\",\"link\":\"https://www.xiaohongshu.com/page/topics/5cc80d19eb1c030001c1acba?naviHidden=yes&autoPlayMedioBack=yes\",\"name\":\"夏日滤镜\",\"id\":\"5cc80d19000000000d03bb71\"}},{\"strength\":1.0,\"category_weight\":1,\"use_count_desc\":\"9.8万人使用\",\"use_count\":98219,\"update_time\":1618559118,\"category_id\":\"动态\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/f4cd4bc611c57f8a567eba6fa4257fba42ba8d71\",\"en_name\":\"M1\",\"id\":\"81a39a34109f4d89a7dee8bec6cdf2c9\",\"filter_url\":\"https://fe-video-qc.xhscdn.com/athena-legacy/90a2761370b36afadcc53fea1e0577d9866f1387/smallsakura.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/4d3df83dacd08509fe5f5c65d0fe5a6946f187ed\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/6d69c816494fc92126de966e3097228c1c68cb96/syh_000_iSpt.webp\",\"special_effect_image\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/b0aba9ee115279058eb986142fb9f38bb5098bf6/syhsl_000_iSpt.webp\",\"source_type\":5,\"entrance_name\":\"恋空滤镜\",\"cn_name\":\"恋空\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/athena-legacy/28be10fd9613ef3c32e3cb7f16aab59daa40167d\"],\"show_process_bar\":0,\"md5\":\"9df8bee7320029de8b2b2869bdd61538\",\"desc\":\"浪漫的不是春天，是你的注视给四季加了滤镜\",\"topic_info\":{\"page_id\":\"5e61eb24f460bb0001b521d3\",\"link\":\"https://www.xiaohongshu.com/page/topics/5e61eb24f460bb0001b521d3?naviHidden=yes&autoPlayMedioBack=yes\",\"name\":\"暖春樱花季\",\"id\":\"5e61eb240000000001002da7\"}},{\"strength\":1.0,\"category_weight\":1,\"use_count_desc\":\"40.2万人使用\",\"use_count\":401854,\"update_time\":1618558697,\"category_id\":\"动态\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/f4cd4bc611c57f8a567eba6fa4257fba42ba8d71\",\"en_name\":\"M11\",\"id\":\"e35494f89be64cdfa563df40227067fb\",\"filter_url\":\"https://dc.xhscdn.com/23d805ac3ae0ab01da847de480938be732667790/huaban02.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/f96e2c19cd9d3c6327a6b9a8ceea044bf434281b\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/0855d80cc41dc4b3c6f21269873bb25edb9d05ce/shuanglietu_000_iSpt.webp\",\"special_effect_image\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/f563b2368ae72542b412d2ae3964aac3b076f8bb/huabna_fuceng_000_iSpt.webp\",\"source_type\":5,\"entrance_name\":\"邂逅滤镜\",\"cn_name\":\"邂逅\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/athena-legacy/9633009cf5454f974c728e68bf9025f60afc6223\"],\"show_process_bar\":0,\"md5\":\"da20683f6fac37cb846383d35fa3ba91\",\"desc\":\"适合人像、自拍等场景\",\"topic_info\":{\"page_id\":\"5e61eb24f460bb0001b521d3\",\"link\":\"https://www.xiaohongshu.com/page/topics/5e61eb24f460bb0001b521d3?naviHidden=yes&autoPlayMedioBack=yes\",\"name\":\"暖春樱花季\",\"id\":\"5e61eb240000000001002da7\"}},{\"strength\":1.0,\"category_weight\":1,\"use_count_desc\":\"491.6万人使用\",\"use_count\":4916419,\"update_time\":1618558773,\"category_id\":\"动态\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/f4cd4bc611c57f8a567eba6fa4257fba42ba8d71\",\"en_name\":\"M12\",\"id\":\"47b4f65c03ce494ca776fc0da62253a8\",\"filter_url\":\"https://dc.xhscdn.com/9a97ea9b3241c41effd470b96ff61698b8ca1d2f/yinghua0318.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/10a38eba6f4a738c60032080c991988935d9c3ab\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/d33f83b3d56b88c9bd9daa080a3f9611e5c63a57/yinghuashuanglie03181740.webp\",\"special_effect_image\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/449f5fed2e6a107d702a25a13b60e35fe01ace4a/yinghua.webp\",\"source_type\":5,\"entrance_name\":\"落樱特效\",\"cn_name\":\"落樱\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/athena-legacy/d54c8291ee0f6b6d0807facfec80c8078c8bd1f0\"],\"show_process_bar\":0,\"md5\":\"b665041fea616c49eac417ba93f25b51\",\"desc\":\"微风吹过，落下粉色的樱花雨。\",\"topic_info\":{\"page_id\":\"5e61eb24f460bb0001b521d3\",\"link\":\"https://www.xiaohongshu.com/page/topics/5e61eb24f460bb0001b521d3?naviHidden=yes&autoPlayMedioBack=yes\",\"name\":\"暖春樱花季\",\"id\":\"5e61eb240000000001002da7\"}},{\"strength\":1.0,\"category_weight\":1,\"use_count_desc\":\"181.2万人使用\",\"use_count\":1812265,\"update_time\":1618558820,\"category_id\":\"动态\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/f4cd4bc611c57f8a567eba6fa4257fba42ba8d71\",\"en_name\":\"M12\",\"id\":\"29cb9b4dda2c4534a1cff990a66763c6\",\"filter_url\":\"https://dc.xhscdn.com/627a02ec9764cbaf62a2524394aa7293ac74ea5b/yinghuochong4.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/f637762a1ac785a90595b481cd6f9132edfcd86b\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/f3cbe1baf397a058ce1e08bc5a4fa6ade6b47aae/yhcshuanglietu.webp\",\"special_effect_image\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/d358937d5dfc37db7c872a4058f424c446a86ed0/yhcsuoluetufuceng.webp\",\"source_type\":5,\"entrance_name\":\"萤火虫滤镜\",\"cn_name\":\"萤火虫\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/athena-legacy/164828702d8323bd185cd039267ecdfabe6feba0\"],\"show_process_bar\":0,\"md5\":\"0bb7c36f3a1a531d41ce650de8ac84f4\",\"desc\":\"适合出行、风景、夜晚效果场景！\",\"topic_info\":{\"page_id\":\"5cc80d19eb1c030001c1acba\",\"link\":\"https://www.xiaohongshu.com/page/topics/5cc80d19eb1c030001c1acba?naviHidden=yes&autoPlayMedioBack=yes\",\"name\":\"夏日滤镜\",\"id\":\"5cc80d19000000000d03bb71\"}},{\"strength\":1.0,\"category_weight\":1,\"use_count_desc\":\"28.7万人使用\",\"use_count\":286506,\"update_time\":1618558857,\"category_id\":\"动态\",\"category_icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/f4cd4bc611c57f8a567eba6fa4257fba42ba8d71\",\"en_name\":\"M13\",\"id\":\"9eea4880bea840dba01b490bc0b619b0\",\"filter_url\":\"https://dc.xhscdn.com/3f67c59c1701857314d58fc3c923452be591b403/fireworks0731.zip\",\"show_tip_icon_type\":0,\"max_strength\":1.0,\"collect_status\":false,\"icon_url\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/athena-legacy/390834d24d36b51d34ba321e3e937eb529f28a52\",\"filter_producer_type\":1,\"user_image\":\"https://img.xiaohongshu.com/avatar/5def5446472a38000160980b.jpg@80w_80h_90q_1e_1c_1x.jpg\",\"share_mask\":\"\",\"special_effect_image\":\"https://xhsci-10008268.cos.ap-shanghai.myqcloud.com/78902756e1646923d464d05fc63c52454c4f8f2d/fuceng_000_iSpt.webp\",\"source_type\":5,\"entrance_name\":\"花火滤镜\",\"cn_name\":\"花火\",\"user_id\":\"5c8628fe00000000110352b7\",\"nick_name\":\"小红书UED\",\"example_image\":[\"https://ci.xiaohongshu.com/athena-legacy/2de6d25970717edeecf320bb3e1454bb2224ca8c\"],\"show_process_bar\":0,\"md5\":\"3dc77aa97b9c474e20325c23efa0fdc4\",\"desc\":\"适合近景人像、风景拍摄\",\"topic_info\":{\"page_id\":\"5cc80d19eb1c030001c1acba\",\"link\":\"https://www.xiaohongshu.com/page/topics/5cc80d19eb1c030001c1acba?naviHidden=yes&autoPlayMedioBack=yes\",\"name\":\"夏日滤镜\",\"id\":\"5cc80d19000000000d03bb71\"}}],\"sub_type\":\"动态\"}],\"type\":\"动态\"}]";
    private String type;
    private List<FilterInfo> filterInfo;

    public static void main(String[] args) {
        List<MediaFilterInfo> filterInfos = JSON.parseArray(filterMsg, MediaFilterInfo.class);

        System.out.println("filterInfos:");
        System.out.println(JSON.toJSONString(filterInfos));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JSONType(naming = PropertyNamingStrategy.SnakeCase)
    public static class FilterInfo {
        private String subType;
        private List<JSONObject> filters;
    }
}