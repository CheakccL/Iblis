package Individual;

import com.mygdx.game.MyActor;

public class MonsterAI {
    //To MRL
    //在这一类中，你需要设定怪物的AI，在怪物actor添加到MainStage的时候，通过不同方式攻击主角
    //Notice: 怪物攻击或受到攻击时会改变模型（可以使用现有的MyActor类，最好额外写一个类）
    //怪物基础属性可通过调用获取，怪物被击中时会降低生命值
    //怪物死亡将会有随机掉落物品，掉落物品
    //怪物是可以被选中的，使用InputListener来实现这一点

    private void meleeMonster(MyActor monster){
        //在此函数中设定近战类敌人的AI
        //离主角较远时靠近主角，贴近时，开始攻击
        //将会调用Model类中的模型，在此之前可以用已经给出的不同颜色小方块代替
    }

    private void missileMonster(MyActor monster){
        //在此函数中设定远程类敌人的AI
        //如离主角较远时靠近主角，进入特定射程时，开始攻击（请勿为所有怪物设定相同的射程和应对方式）
        //将会调用Model类中的模型，在此之前可以用已经给出的不同颜色小方块代替
    }

    private void eliteMonster(MyActor monster){
        //在此函数中设定精英级以上敌人的AI
        //可以给它们设定特殊攻击方式
        //拥有更高的掉落物品几率
        //Boss死亡则开启下一关的传送门
        //将会调用Model类中的模型，在此之前可以用已经给出的不同颜色小方块代替
    }

    private void monsterDrop(MyActor monster){
        //在此函数中设定敌人的掉落，包括药水和装备
    }
}
