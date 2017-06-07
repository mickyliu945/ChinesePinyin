package com.micky.chinesepinyin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.micky.pinyin4j.Pinyin;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tvResult = (TextView) findViewById(R.id.tv_result);
        final EditText etSouce = (EditText) findViewById(R.id.et_source);
        etSouce.setText("据介绍，为更好地对雄安新区进行规划，中央组织了中国规划设计研究院和国内顶级的规划单位成立联合工作营，包括清华大学规划院、同济大学规划院、东南大学规划院、北京城市规划院、深圳城市规划院、天津城市规划院等6家单位，进行了多轮方案的研讨和完善。与此同时，成立了雄安新区规划评议专家组，包括地理、地质、水文、生态、能源、交通、建筑学领域的30多位专家，对各个方案进行评审、讨论，预计不久后将提交中央审查。徐匡迪指出，新区建设必须要有交通支撑，以高铁架构首都一体两翼，北起秦皇岛、山海关、唐山，最南到邢台、邯郸。“以北京首都机场为顶点，建设北京、天津、雄安三角地带，构建面向国际、辐射全国、服务区域的空铁一体化的交通网络，服务京津冀同时也辐射张北、崇礼地区，推进河北省两翼齐飞的发展格局。值得注意的是，21世纪的地下管廊式基础设施是新区建设的一大亮点。徐匡迪透露，雄安新区建设将把城市交通、城市水、电、煤气供应、灾害防护系统全部放在地下，以高铁、车站、市内交通等为例，均会置于地下。而地上部分将让给绿化、让给人行道。“人行走500米就可以下到地下找到车站，到四面八方去。届时通过高铁到达北京仅需41分钟。”他说。支撑打造现代产业体系中国社科院工业经济所所长、京津冀协同发展智库负责人黄群慧表示，新区产业总体思路是，以高端制造为先导培育创新生态系统，进而打造高端制造业和生产性服务业融合发展的主导现代产业体系。黄群慧介绍，高端制造业包括智慧制造、绿色制造、服务制造。绿色制造满足雄安生态定位，智慧制造满足雄安智慧城市的定位，服务制造满足作为科研新城的定位。“因为新区并不是科技孤岛，他需要相应产业体系支撑。”空间布局方面，将以功能组团布局主导产城融合要素配置，重点形成中央商务组团、绿色宜居组团、高端产业组团、大学研发区组团和滨海的生态休闲组团。中国工程院院士、京津冀协同发展专家咨询委员会副组长邬贺铨表示，从长三角和珠三角城市群来看，不仅是地理位置接近，而且是产业高度关联。但河北的产业结构偏重，和北京的产业有差异化，没有互补性，也造成北京的科技成果转化和产业配套往往舍近求远。调查显示，中关村的科技成果量转移到珠三角和长三角的是转移到河北和天津的两倍。在考虑全国要素产业错位的基础上，邬贺铨认为，围绕雄安新区智慧城市、生态城市、创新城市、服务城市、畅通城市、开放城市、改革城市等七大任务，雄安产业布局将打造智慧城市、高新高端制造、生态等三大产业。其中，智慧城市方面，将包括环保、交通传感器、大数据分析设备与软件，新型光复材料，地热设备等产业;高新高端制造方面，将包括汽车电子与车联网、人工智能芯片与软件、生产性服务业、生物制造与基因工程等产业;生态城市方面，将包括水质治理与检测、生态恢复、绿色建筑等产业。国家发改委副秘书长范恒山指出，打造雄安新区、京津冀世界级城市群有利于形成中心带动、协同发展、一体联动的格局。他表示，京津冀三地存在城镇体系失衡，大中小城市改革发展绝不被房地产绑架邬贺铨表示，对于新区来说，房地产改革将是一项重要任务。“过去很多地方已经出现了房价过快上涨甚至失控的情况，不能让新区重蹈覆辙。”此前，邬贺铨表示，雄安新区是改革开放的先行区，将试验房地产发展新模式——既能够发展房地产，又能够控制房地产价格，保障居民住房需求。对此，国土资源部调控和监测司巡视员董祚继建议，应将70年土地批租制，改为土地年租制，发挥土地国有优势，创新用地制度，助力雄安建设。董祚继认为，从目前的土地制度来看，城市土地国有，两权分置，虽然促进了我国开发区建设、国企改革、房地产业的发展，但也造成了地方政府对土地财政的严重依赖，推高了房价，加大了金融风险。董祚继说，土地年租制并不意味着将回到计划配置土地的老路，回到无偿使用土地的老路，而是遵循城市发展规律，坚持市场配置土地，发挥土地所有优势，改革土地出让制度。具体来说，土地批租制就是70年一次性出让;土地年租制就是实行按年或者3-5年的短期租赁。这样，一方面，可以避免地方政府对土地财政的严重依赖所诱发的短期行为;另一方面，将有效降低土地初始取得成本，抑制房地产的投资投机需求，杜绝企业的圈地行为，还能够实现土地增值共享，促进社会公平。董祚继认为，土地年租之下的房地产模式，将既不同于70年产权的商品房，也将不同于几乎不支出土地出让金的廉租房或经济适用房，而是支付了相应土地出让金的产权模式。“土地的产权以及租金仍需通过拍卖取得。”董祚继表示，只不过拍卖对象不再是70年，而是年度或3至5年时间，年租金与房地产税实行合并征收。这样一来，一方面实现了坚持土地国有制度，另一方面坚持了市场化配置土地，保持了竞争方式。此外，居民也拥有了住房的居住权与产权。");
        findViewById(R.id.btn_parse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Pinyin pinyin = new Pinyin();
                            pinyin.init(MainActivity.this);

                            String source = etSouce.getText().toString();
                            long startTime = System.currentTimeMillis();
                            List<String> pinyinList = pinyin.getPinyin(source);
                            String tip = "字数" + source.length() +", 耗时：" + (System.currentTimeMillis() - startTime) + "毫秒\n";
                            Log.i(TAG, tip);

                            final StringBuffer sb = new StringBuffer(tip);
                            for (String str : pinyinList) {
                                sb.append(" ").append(str);
                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvResult.setText(sb.toString());
                                }
                            });
                        }
                    }).start();
                    //System.out.println(pinyin);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
