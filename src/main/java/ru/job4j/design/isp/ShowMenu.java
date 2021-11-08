package ru.job4j.design.isp;

public class ShowMenu {
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        Button button = new Button("Start");
        Button button1 = new Button("go go");
        Button button2 = new Button("finish");
        Button button3 = new Button("ff6");
        Button button4 = new Button("dd");
        Button button5 = new Button("kk");
        menu.add(button);
        button.add(button1);
        button.add(button3);
        button1.add(button4);
        button4.add(button5);
        menu.add(button2);
        Menu menu2 = new Menu();
        menu.show(menu);
        System.out.println(menu.getBut("1.1.1").getName());
    }
}
