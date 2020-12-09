package Individual;

import com.mygdx.game.MyActor;

public class AttributeCall {
    //To LHL
    //在此类中需要完成所有有关数值的设定
    //此类中所有函数都将被大量调用

    private float damageDone(MyActor actor/*; MyActor monster*/) {
        //在此函数中，你需要定义每次攻击/技能造成的伤害
        //将会传入主角和怪物，通过计算得出造成的伤害并传回
        return 1f;
    }

    private void enemyAttribute(MyActor actor) {
        //在此函数中，你需要为敌人设定属性值
        //基础推荐属性值已经在之前开发文档中给出
        //将会传入怪物，通过计算得出怪物的攻击力和血量(通过关卡，离初始点的远近等元素)
    }

    private void levelup() {
        //在此函数中，你需要设定升级之后的事件
        //升级后，基础属性点将会提升，并取得一点技能点和数点属性点
    }

    //需要解决其他成员的额外需求
}
