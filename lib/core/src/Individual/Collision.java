package Individual;

public class Collision {
    //To WWX
    //在这一类中，你需要完成模型碰撞的检测以及实现碰撞后应该发生的事件
    //Notice: 地图的碰撞也需要制作
    //教程7.4节会对碰撞检测很有帮助
    //所有模型可以暂时用已经给出的小色块代替

    private void collisionDetect() {
        //在此函数中，你需要检测到碰撞
        //通过验证两个rect重合的面积是否大于特定数值
        //怪物的攻击不能命中其他怪物
    }

    private void collisionSet() {
        //在此函数中，你需要为Actor定义碰撞体积
        //此函数将被其他类调用
    }

    private void mapCollision() {
        //在此函数中，你需要为地图定义碰撞体积
        //确保所有Actor都不会走出地图，以及穿过地图定义的墙
    }

    private boolean hit() {
        //在此函数中，你需要检测到攻击是否命中（通过判断双方距离，如果已经有较大距离，则不能命中）
        //命中之后，受到攻击的一方将会扣血，造成伤害的一方也需要收到造成伤害的通知
        return true;
    }
}
