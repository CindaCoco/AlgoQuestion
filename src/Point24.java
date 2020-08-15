import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Point24 {
    public boolean judgePoint24(int[] nums){
        List<Double> list = new ArrayList<>();
        for(int x:nums){
            list.add((double)x);
        }
        return dfs(list);
    }

    public boolean dfs(List<Double> list){
        //终止条件，当size为1时判断
        if(list.size()==1){
            return Math.abs(list.get(0) - 24) < 0.001;
        }

        //size不为一，则遍历所有的情况，一共有C_n^2种
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                for(double c:compute(list.get(i),list.get(j))){
                    List<Double> nextRound = new ArrayList<>();
                    nextRound.add(c);
                    for(int k=0;k<list.size();k++){
                        if(k==i||k==j){
                            continue;
                        }
                        nextRound.add(list.get(k));
                    }

                    //深度优先遍历
                    if(dfs(nextRound)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<Double> compute(double a,double b){
        return Arrays.asList(a+b,a-b,b-a,a*b,a/b,b/a);
    }



}
