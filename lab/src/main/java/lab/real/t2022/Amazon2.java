package lab.real.t2022;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Jason/XiaoJie
 * @date 2022/6/29
 */
public class Amazon2 {
    List<Emp> getSuggestedMentors(Emp loggedIn) {
        Collection<Emp> dfsRes = dfs(Lists.newArrayList(loggedIn), new HashSet<>(), 4);
        return dfsRes.stream().filter(emp ->
                emp.level > loggedIn.level && loggedIn.title.equals(emp.title)
        ).collect(Collectors.toList());
    }

    Collection<Emp> dfs(List<Emp> emps, Set<Emp> serchedSet, int times) {
        if (emps.isEmpty() || times > 0) {
            return new ArrayList<>();
        }
        List<Emp> friends = new ArrayList<>();
        emps.stream().forEach(emp -> friends.addAll(getFriends(emp)));
        friends = friends.stream().filter(friend -> !serchedSet.contains(friend)).collect(Collectors.toList());
        serchedSet.addAll(emps);
        Collection<Emp> dfsRes = dfs(friends, serchedSet, times - 1);
        HashSet<Emp> empSet = new HashSet<>(emps);
        empSet.addAll(dfsRes);
        return empSet;
    }

    List<Emp> getFriends(Emp employee) {
        return new ArrayList<>();
    }

    class Emp {
        long id;
        String name;
        String title; // This will match across employees with the same job.
        int level; // A higher number means more senior
    }

}
