package zqq_pokergame;

import java.util.*;

public class PokerRegular {

	public static String of(List<PokerCard> Black, List<PokerCard> White){
        List<Integer> bn = new ArrayList<>();
        List<String> bc = new ArrayList<>();
        List<Integer> wn = new ArrayList<>();
        List<String> wc = new ArrayList<>();
        for (Map.Entry<List, List> list : PokerRegular.place(Black).entrySet()) {
            bn = list.getKey();
            bc = list.getValue();
        }
        for (Map.Entry<List, List> list : PokerRegular.place(White).entrySet()) {
            wn = list.getKey();
            wc = list.getValue();
        }
        Collections.sort(bn, (Integer o1, Integer o2) -> {
                return o2-o1;
            });
        Collections.sort(wn,(Integer o1, Integer o2) -> {
            return o2-o1;
        });
        int bt = judgeType(bn,bc);
        int wt = judgeType(wn,wc);
        if (bt < wt)
            return "Black wins";
        else if (bt > wt)
            return "White wins";
        else{
            if (comp(bn,wn) == 1)
                return "Black wins";
            else
                return "White wins";
        }

    }
    public static Map<List,List> place(List<PokerCard> card){
        List<Integer> cn = new ArrayList<>();
        List<String> cc = new ArrayList<>();
        ListIterator<PokerCard> ci = card.listIterator();
        while(ci.hasNext()){
        	PokerCard next = ( PokerCard ) ci.next();
            if (next.number == "A")
                cn.add(14);
            else if (next.number == "K")
                cn.add(13);
            else if (next.number == "Q")
                cn.add(12);
            else if (next.number == "J")
                cn.add(11);
            else cn.add(Integer.parseInt(next.number));
            cc.add(next.color);
        }
        HashMap<List,List> map = new HashMap<>();
        map.put(cn,cc);
        return map;
    }
    public static int isRoyalFlush(List<Integer> n,List<String> c){
        if(PokerRegular.isFlush(c) == 4 && PokerRegular.isStriaght(n) == 5)
            return 1;
        else
            return 0;
    }

    public static int isFlush(List<String> list){
        if (list.get(0) == list.get(1) && list.get(1) == list.get(2) && list.get(2) == list.get(3) && list.get(3) == list.get(4))
            return 4;
        else
            return 0;
    }
    public static int isStriaght(List<Integer> list){
        if(list.get(0)-list.get(1) == list.get(1)-list.get(2) && list.get(2)-list.get(3) == list.get(3)-list.get(4)
        && list.get(3)-list.get(4) == 1)
            return 5;
        else
            return 0;
    }
    public static int isPairs(List<Integer> list){
        if (list.get(0)==list.get(1)){
            if(list.get(2)==list.get(3) || list.get(3)==list.get(4))
                return 7;
            else
                return 8;
        }else if (list.get(1)==list.get(2)){
            if (list.get(3)==list.get(4))
                return 7;
            else
                return 8;
        }else if (list.get(2)==list.get(3) || list.get(3)==list.get(4))
            return 8;
        else
            return 0;
    }
    public static int isThree(List<Integer> list){
        if(list.get(0) == list.get(1) && list.get(1) == list.get(2)){
            if (list.get(3) == list.get(4))
                return 3;
            else
                return 6;
        }else if ((list.get(1) == list.get(2) && list.get(2) == list.get(3)) || (list.get(2) == list.get(3) && list.get(3) == list.get(4))){
            return 6;
        }else
            return 0;
    }
    public static int isFour(List<Integer> list){
        if ((list.get(0)==list.get(1) && list.get(1)==list.get(2) && list.get(2)==list.get(3)) ||
                (list.get(1)==list.get(2) && list.get(2)==list.get(3) && list.get(3)==list.get(4)))
            return 2;
        else
            return 0;
    }
    public static int judgeType(List<Integer> n,List<String> c){
        int flag;
        if (isPairs(n) != 0)
            flag = isPairs(n);
        else if (isThree(n) != 0)
            flag = isThree(n);
        else if (isStriaght(n) != 0)
            flag = isStriaght(n);
        else if (isFlush(c) != 0)
            flag = isFlush(c);
        else if (isFour(n) != 0)
            flag = isFour(n);
        else if (isRoyalFlush(n,c) != 0)
            flag = isRoyalFlush(n,c);
        else
            flag = 0;
        return 0;
    }
    public static int comp(List<Integer> first,List<Integer> second){
        int flag = 0;
        for (int i = 0; i < 5; i++) {
            if(first.get(i) > second.get(i)){
                flag = 1;
                break;
            }
            else if (first.get(i) < second.get(i)){
                flag = -1;
                break;
            }
            else
                continue;
        }
        return flag;
    }
}
