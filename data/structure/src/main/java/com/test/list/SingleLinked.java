package com.test.list;

import com.test.list.model.Hero;

public class SingleLinked {

    // 创建头节点
    private Hero head = new Hero(0, "", "");

    public void list(){
        if (head.getNext() ==  null){
            System.out.println("表为空");
            return;
        }
        Hero temp = head.getNext();
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    /**
     * 直接添加到下一个位置
     * @param hero
     */
    public void add(Hero hero){
        Hero temp = head;
        while (true){
            if (temp.getNext() == null){
                // temp.setNext(hero);
                break;
            }
            // 下一个域不为空，则temp向下移
            temp = temp.getNext();
        }
        temp.setNext(hero);
    }

    /**
     * 按照顺序进行添加
     * @param hero
     */
    public void addByOrder(Hero hero){
        Hero temp = head;
        // 判断编号是否存在
        boolean flag = false;
        while (true){
            if (temp.getNext() == null){
                break;
            }
            if (temp.getNext().getNo() > hero.getNo()){
                break;
            }
            // 编号已存在
            if (temp.getNext().getNo() == hero.getNo()){
                flag = true;
                break;
            }
            // 下一个域不为空，则temp向下移
            temp = temp.getNext();
        }
        if (flag){
            System.out.println("编号已存在");
        } else {
            hero.setNext(temp.getNext());
            temp.setNext(hero);
        }
    }

    public void update(Hero hero){
        if (head.getNext() == null){
            System.out.println("表为空");
            return;
        }
        Hero temp = head.getNext();
        // 判断是否找到了对应编号的英雄
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if (temp.getNo() == hero.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag){
            temp.setName(hero.getName());
            temp.setNickname(hero.getNickname());
        } else {
            System.out.println("未找到节点");
        }
    }

}
