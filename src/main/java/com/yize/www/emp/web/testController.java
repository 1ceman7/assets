package com.yize.www.emp.web;


public class testController {
    private int k;
    private String L;
    public int getK() {
        return k;
    }
    public void setK(int k) {
        this.k = k;
    }
    public String getL() {
        return L;
    }
    public void setL(String l) {
        L = l;
    }

    private testController() {};
    private static testController tt = new testController();
    public static testController getTT(){
        return tt;
    };
    public String getEmp(){
       return new String("测试");
    };
    public static void main(String[] args) {
        System.out.println(getTT().getEmp());
        int k = getTT().getK();
        k = 90;
        String ice = getTT().getL();
        ice = "Ice"+k;
        System.out.println(k+"和"+ice);
        String s = "1";
        String h = new String("晕");
        System.out.println(h+";"+s);
        int a = 2;
        int b = a;
        int n = 3;
        for (int i=1;i<n;i++){
            a=a*b;
        }
        System.out.println("a的"+n+"次方="+a);
        System.out.println("b="+b);

    }
}
