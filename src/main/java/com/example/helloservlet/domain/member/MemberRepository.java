package com.example.helloservlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*  동시성 문제가 고려되어 있지 않으므로, 실무에서는 ConcurrentHashMap, Automic Long으로 해야함
*
* */

public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();


    // static method를 통해서만 객체를 조회하도록 한다.
    public static MemberRepository getInstance() {
        return instance;
    }

    // private 생성자를 통해서 외부에서 new로 객체를 생성하는 것을 막는다.
    private MemberRepository() {

    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }







}
