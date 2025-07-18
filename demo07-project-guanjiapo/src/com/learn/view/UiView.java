package com.learn.view;

import com.learn.entiry.GjpZhangWu;
import com.learn.service.GjpZhangWuService;
import com.learn.service.impl.GjpZhangWuServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class UiView {
    private final GjpZhangWuService gjpZhangWuService = new GjpZhangWuServiceImpl();
    private final Scanner scanner = new Scanner(System.in);
    private void start() {
        boolean flag = true;
        while (flag) {
            System.out.println("---------------管家婆家庭记账软件---------------");
            System.out.println("1.添加账务 2.编辑账务 3.删除账务 4.查询账务 5.退出系统");
            System.out.print("请输入要操作的功能序号[1-5]:");
            int op = scanner.nextInt();
            switch (op) {
                case 1:
                    addZhangWu();
                    break;
                case 2:
                    editZhangWu();
                    break;
                case 3:
                    deleteZhangWu();
                    break;
                case 4:
                    selectZhangWu();
                    break;
                case 5:
                    System.out.println("再见！");
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误！");
            }
        }
    }
    private void editZhangWu() {
        System.out.print("请输入要编辑的账务ID：");
        int editId = scanner.nextInt();
        GjpZhangWu zw = gjpZhangWuService.findById(editId);
        if(zw == null) {
            System.out.println("账务不存在！");
            return;
        }
        System.out.print("支出类型：" + zw.getFlname());
        System.out.print(", 金额：" + zw.getMoney());
        System.out.print(", 支付账户：" + zw.getZhangHu());
        System.out.println(", 描述：" + zw.getDescription());

        GjpZhangWu newZw = getZhangWu();
        newZw.setZwid(zw.getZwid());

        boolean success = gjpZhangWuService.edit(newZw);
        System.out.println(success ? "修改成功" : "修改失败");
    }
    private void deleteZhangWu() {
        System.out.print("请输入要删除的账务ID：");
        int id = scanner.nextInt();
        GjpZhangWu zw = gjpZhangWuService.findById(id);
        if(zw == null) {
            System.out.println("账务不存在！");
            return;
        }

        boolean success = gjpZhangWuService.delete(id);
        System.out.println(success ? "删除成功" : "删除失败");
    }

    private GjpZhangWu getZhangWu() {
        GjpZhangWu zw = new GjpZhangWu();
        System.out.print("请输入支出类型：");
        String flname = scanner.next();
        System.out.print("请输入金额：");
        double money = scanner.nextDouble();
        System.out.print("请输入账户：");
        String zhangHu = scanner.next();
        System.out.print("请输入描述：");
        String des = scanner.next();
        Date date = new Date();

        zw.setFlname(flname);
        zw.setMoney(money);
        zw.setZhangHu(zhangHu);
        zw.setCreatetime(date);
        zw.setDescription(des);
        return zw;
    }
    private void addZhangWu() {
        GjpZhangWu zw = getZhangWu();

        boolean success = gjpZhangWuService.addOne(zw);
        System.out.println(success ? "新增成功" : "新增失败");
    }

    private void showAllZhangWu() {
        List<GjpZhangWu> all = gjpZhangWuService.selectAll();
        if(all.size() == 0) {
            System.out.println("数据为空！");
            return;
        }
        all.forEach(System.out::println);
    }
    private void showDateRangeZhangWu() {
        System.out.print("请输入开始时间：");
        String start = scanner.next();
        System.out.print("请输入结束时间：");
        String end = scanner.next();
        List<GjpZhangWu> result = gjpZhangWuService.selectByDataRange(start, end);
        if(result.size() == 0) {
            System.out.println("未查询到相关数据！");
            return;
        }
        result.forEach(System.out::println);
    }

    private void selectZhangWu() {
        System.out.println("1.查询全部    2.按时间范围查询");
        while (true) {
            System.out.print("请选择：");
            int i = scanner.nextInt();
            if(i == 1) {
                showAllZhangWu();
                break;
            }
            if(i == 2) {
                showDateRangeZhangWu();
                break;
            }
            System.out.println("输入有误，请重新输入！");
        }
    }

    public static void main(String[] args) {
        new UiView().start();
    }
}