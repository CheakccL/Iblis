package Individual;

import com.badlogic.gdx.ScreenAdapter;

public class UIStage extends ScreenAdapter {
    //To HHX
    //在此类中，你需要绘制出主界面之外的界面，包括主菜单界面，属性栏界面，技能树界面，装备栏界面
    //界面需要通过在主界面按键调用，每个界面中需要有buttons进行操作，教程6.3可能会很有帮助

    private void mainMenu(){
        //在此函数中，你需要绘制主菜单stage
        //在游戏开始时进入此界面（在完成其他功能后再实现）
        //其中至少包括三个按钮 start, read background story, exit
        //需要实现按钮的相应功能
    }

    private void attributePanel() {
        //在此函数中，你需要绘制属性栏界面
        //属性栏需要显示主角的攻击力，智力，护甲和魔抗
        //升级之后有属性点可以分配，可增加属性点需要实时显示
    }

    private void equipmentPanel() {
        //在此函数中，你需要绘制装备界面
        //装备界面需要显示主角现在穿着的装备
    }

    private void skillPanel() {
        //在此函数中，你需要绘制技能树界面
        //技能树界面需要显示主角的技能，已学/未学
        //升级之后可以学习技能，这意味着每个技能都需要是一个按钮，并附带技能等级数值
        //可以给技能添加释放快捷键，如QWER
        //Notice: 每个角色的技能不同
    }

}
