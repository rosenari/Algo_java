package Stream연습;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream_Train {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};

        System.out.println(Arrays.stream(arr).count());
        System.out.println(IntStream.of(arr).count()); 
        System.out.println(Arrays.stream(arr).reduce(0, Integer::sum)); 

        IntStream.of(arr).forEach((v) -> { System.out.print(v+" "); });

        String[] strs = Arrays.stream(arr).mapToObj(num -> num + "").toArray(String[]::new);
        for(String str : strs) System.out.print(str);

        System.out.println();

        int[] nums = IntStream.iterate(2, num -> num * 2).limit(5).toArray();
        for(int num : nums) System.out.print(num + " ");

        System.out.println();
        //String to charArray
        char[] chs = Arrays.stream("1 0 0 1 0 0".split(" ")).collect(Collectors.joining()).toCharArray();

        //성인 필터링
        Arrays.stream(new int[]{25, 26, 19, 15, 14, 12, 11, 50, 47, 30}).filter(age -> age < 19).forEach(age -> System.out.print(age + " "));
        System.out.println();

        //모든 숫자에 10씩 더하기
        Arrays.stream(new int[]{1,2,3,4,5,6}).map(num -> num + 10).forEach(num -> System.out.print(num + " "));
        System.out.println();

        //사람들의 정보를 나이를 기준으로 오름차순 정렬하여 저장후 출력
        Human[] humans = new Human[]{new Human("rosenari", 30), new Human("jiyoung", 27), new Human("color kim", 20)};
        Human[] copyHumans = Arrays.stream(humans).sorted(new Comparator<Human>(){
            public int compare(Human o1, Human o2) {
                return o1.getAge() - o2.getAge();
            }
        }).toArray(Human[]::new);
        Arrays.stream(copyHumans).forEach(System.out::println);

        //사람배열을 리스트로 변환하여 저장한 뒤 정보 출력
        List<Human> list = Arrays.asList(humans);//asList는 고정된 ArrayList를 반환한다 즉, add 메서드가 없음.
        list.stream().forEach(System.out::println);

        //사람들의 나이를 전부 더하기
        int total = Arrays.stream(humans).mapToInt(Human::getAge).reduce(0, (sum, age) -> sum + age);
        System.out.println(total);

        //사람들 중 가장 나이많은 사람의 정보를 출력하라
        System.out.println(list.stream().reduce(Human::max).get());

        //정수배열에서 최대값을 구하여라. 최대값이 없을 경우 0을 출력한다.
        nums = new int[]{1,2,3,4,5,100,-1,-5,-10};
        int max = Arrays.stream(nums).max().orElse(0);
        System.out.printf("max : %d\n", max);

        //정수 배열에서 최소값을 구하여라. 최소값이 없을 경우 0을 출력한다.
        int min = Arrays.stream(nums).min().orElse(0);
        System.out.printf("min : %d\n", min);

        //사람들의 나이를 합하여라. 병렬 스트림으로 처리하라.
        System.out.println(list.parallelStream().mapToInt(Human::getAge).reduce(0,(sum, age) -> sum + age));
    }

    static class Human{
        private String name;
        private int age;
        Human(String name, int age){
            this.name = name;
            this.age = age;
        }

        public int getAge(){
            return this.age;
        }

        public String toString(){
            return "Human [ name: " + name +" ,age: " + age +" ]";
        }

        public static Human max(Human h1, Human h2){
            return h1.getAge() > h2.getAge() ? h1 : h2;
        }
    }
}
