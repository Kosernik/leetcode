package MonthlyChallenges.Year23.July;

import java.util.*;

public class SmallestSufficientTeam {
    public static void main(String[] args) {
        SmallestSufficientTeam solution = new SmallestSufficientTeam();
        String[] req_skills = {"mwobudvo", "goczubcwnfze", "yspbsez", "pf", "ey", "hkq"};
        List<List<String>> people = new ArrayList<>();
        people.add(new ArrayList<>());
        //[],

        List<String> list = new ArrayList<>();
        list.add("mwobudvo");
        people.add(list);
        // ["mwobudvo"],

        List<String> list1 = new ArrayList<>();
        list1.add("hkq");
        people.add(list1);
        // ["hkq"],

        List<String> list2 = new ArrayList<>();
        list2.add("pf");
        people.add(list2);
        // ["pf"],

        List<String> list3 = new ArrayList<>();
        list3.add("pf");
        people.add(list3);
        // ["pf"],

        List<String> list4 = new ArrayList<>();
        list4.add("mwobudvo");
        list4.add("pf");
        people.add(list4);
        // ["mwobudvo","pf"],

        List<String> list5 = new ArrayList<>();
        people.add(list5);
        // [],

        List<String> list6 = new ArrayList<>();
        list6.add("yspbsez");
        people.add(list6);
        // ["yspbsez"],

        List<String> list7 = new ArrayList<>();
        people.add(list7);
        // [],

        List<String> list8 = new ArrayList<>();
        list8.add("hkq");
        people.add(list8);
        // ["hkq"],

        List<String> list9 = new ArrayList<>();
        people.add(list9);
        // [],

        List<String> list10 = new ArrayList<>();
        people.add(list10);
        // [],

        List<String> list11 = new ArrayList<>();
        list11.add("goczubcwnfze");
        list11.add("pf");
        list11.add("hkq");
        people.add(list11);
        // ["goczubcwnfze","pf","hkq"],

        List<String> list12 = new ArrayList<>();
        list12.add("goczubcwnfze");
        people.add(list12);
        // ["goczubcwnfze"],

        List<String> list13 = new ArrayList<>();
        list13.add("hkq");
        people.add(list13);
        // ["hkq"],

        List<String> list14 = new ArrayList<>();
        list14.add("mwobudvo");
        people.add(list14);
        // ["mwobudvo"],

        List<String> list15 = new ArrayList<>();
        people.add(list15);
        // [],

        List<String> list16 = new ArrayList<>();
        list16.add("mwobudvo");
        list16.add("pf");
        people.add(list16);
        // ["mwobudvo","pf"],

        List<String> list17 = new ArrayList<>();
        list17.add("pf");
        list17.add("ey");
        people.add(list17);
        // ["pf","ey"],

        List<String> list18 = new ArrayList<>();
        list18.add("mwobudvo");
        people.add(list18);
        // ["mwobudvo"],

        List<String> list19 = new ArrayList<>();
        list19.add("hkq");
        people.add(list19);
        // ["hkq"],

        List<String> list20 = new ArrayList<>();
        people.add(list20);
        // [],

        List<String> list21 = new ArrayList<>();
        list21.add("pf");
        people.add(list21);
        // ["pf"],

        List<String> list22 = new ArrayList<>();
        list22.add("mwobudvo");
        list22.add("yspbsez");
        people.add(list22);
        // ["mwobudvo","yspbsez"],

        List<String> list23 = new ArrayList<>();
        list23.add("mwobudvo");
        list23.add("goczubcwnfze");
        people.add(list23);
        // ["mwobudvo","goczubcwnfze"],

        List<String> list24 = new ArrayList<>();
        list24.add("goczubcwnfze");
        list24.add("pf");
        people.add(list24);
        // ["goczubcwnfze","pf"],

        List<String> list25 = new ArrayList<>();
        list25.add("goczubcwnfze");
        people.add(list25);
        // ["goczubcwnfze"],

        List<String> list26 = new ArrayList<>();
        list26.add("goczubcwnfze");
        people.add(list26);
        // ["goczubcwnfze"],

        List<String> list27 = new ArrayList<>();
        list27.add("mwobudvo");
        people.add(list27);
        // ["mwobudvo"],

        List<String> list28 = new ArrayList<>();
        list28.add("mwobudvo");
        list28.add("goczubcwnfze");
        people.add(list28);
        // ["mwobudvo","goczubcwnfze"],

        List<String> list29 = new ArrayList<>();
        people.add(list29);
        // [],

        List<String> list30 = new ArrayList<>();
        list30.add("goczubcwnfze");
        people.add(list30);
        // ["goczubcwnfze"],

        List<String> list31 = new ArrayList<>();
        people.add(list31);
        // [],

        List<String> list32 = new ArrayList<>();
        list32.add("goczubcwnfze");
        people.add(list32);
        // ["goczubcwnfze"],

        List<String> list33 = new ArrayList<>();
        list33.add("mwobudvo");
        people.add(list33);
        // ["mwobudvo"],

        List<String> list34 = new ArrayList<>();
        people.add(list34);
        // [],

        List<String> list35 = new ArrayList<>();
        list35.add("hkq");
        people.add(list35);
        // ["hkq"],

        List<String> list36 = new ArrayList<>();
        list36.add("yspbsez");
        people.add(list36);
        // ["yspbsez"],

        List<String> list37 = new ArrayList<>();
        list37.add("mwobudvo");
        people.add(list37);
        // ["mwobudvo"],

        List<String> list38 = new ArrayList<>();
        list38.add("goczubcwnfze");
        list38.add("ey");
        people.add(list38);
        // ["goczubcwnfze","ey"]

//        List<String> list39 = new ArrayList<>();
//        people.add(list39);


        System.out.println(Arrays.toString(solution.smallestSufficientTeam(req_skills, people)));
    }


    int numberOfPeople = 0;

    // skill name -> idx
    Map<String, Integer> skillIndexes = new HashMap<>();

    // idx -> bit mask
    Map<Integer, Integer> personSkills = new HashMap<>();

    long[] computed;

    /**
     * LeetCode #1125. Smallest Sufficient Team.
     *
     * @param req_skills - an array of required skills.
     * @param people     - a list of skills of each person.
     * @return - any sufficient team of the smallest possible size, represented by the index of each person.
     */
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        numberOfPeople = people.size();

        computed = new long[1 << req_skills.length];
        Arrays.fill(computed, -1L);


        for (int i = 0; i < req_skills.length; i++) {
            skillIndexes.put(req_skills[i], i);
        }

        for (int i = 0; i < people.size(); i++) {
            int bitMaskPersonSkills = getPersonBitMask(people.get(i));
            personSkills.put(i, bitMaskPersonSkills);
        }

        long bestTeam = helper((1 << req_skills.length) - 1);

        int[] result = new int[Long.bitCount(bestTeam)];
        int idx = 0;
        for (int i = 0; i < numberOfPeople; i++) {
            if (((bestTeam >> i) & 1) == 1) {
                result[idx++] = i;
            }
        }

        return result;
    }

    private long helper(int bitMaskSkills) {
        if (bitMaskSkills == 0) {
            return 0L;
        } else if (computed[bitMaskSkills] != -1) {
            return computed[bitMaskSkills];
        }

        for (int person = 0; person < numberOfPeople; person++) {
            int removeSkills = bitMaskSkills & ~personSkills.get(person);
            if (bitMaskSkills != removeSkills) {
                long curResult = helper(removeSkills) | (1L << person);
                if (computed[bitMaskSkills] == -1 || Long.bitCount(curResult) < Long.bitCount(computed[bitMaskSkills])) {
                    computed[bitMaskSkills] = curResult;
                }
            }
        }

        return computed[bitMaskSkills];
    }


    private int getPersonBitMask(List<String> skills) {
        int mask = 0;

        for (String skill : skills) {
            int idx = skillIndexes.get(skill);
            mask |= (1 << idx);
        }

        return mask;
    }
}
