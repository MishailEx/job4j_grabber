package ru.job4j.design.isp;

public class MenuConsole implements ShowMenu {
    @Override
    public void show(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) throws Exception {
        Menu menu = new MenuClass();
        menu.addParent("start", new ActionBut());
        menu.addChild("start", "www", new ActionBut());
        menu.addChild("www", "aaa", new ActionBut());
        menu.addParent("finish", new ActionBut());
        ShowMenu showMenu = new MenuConsole();
        menu.addChild("www", "ppp", new ActionBut());
        menu.addChild("start", "uuu", new ActionBut());
        menu.addChild("ppp", "ooo", new ActionBut());
        showMenu.show(menu.allMenu());
        menu.select("www").act();
    }


}
