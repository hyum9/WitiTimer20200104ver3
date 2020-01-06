package com.example.demo.controller;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;


@RequestMapping("/member")
@RestController
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;
    
    @PostMapping("/insert") // CREATE
    public Member insert(@RequestBody Map<String, String> map){
        return (memberRepository).save(
                new Member(map.get("name"), intParser(map.get("age")), map.get("address"))
        );
    }

    @GetMapping("/select") // READ
    public List<Member> selectAll(){
        return (memberRepository.findAll());
    }

    @GetMapping("/select/{id}") // READ
    public Member selectOne(@PathVariable("id") long id){
        return (memberRepository.findById(id).orElse(null));
    }

    @PostMapping("/update/{id}") // UPDATE
    public Member updateOne(@PathVariable("id") long id, @RequestBody Map<String, String> map){
        System.out.println(id);
        System.out.println(map);
        Member member = memberRepository.findById(id).orElse(null);
        member.setName(map.get("name"));
        member.setAge(intParser(map.get("age")));
        member.setAddress(map.get("address"));
        return memberRepository.save(member);
    }

    @PostMapping("/delete/{id}") // DELETE
    public String deleteOne(@PathVariable("id") long id){
        memberRepository.deleteById(id);
        return "���� �Ϸ�";
    }

    int intParser(String age){
        try{
            return Integer.parseInt(age);
        } catch(ClassCastException e){
            e.printStackTrace();
            return 0;
        }
    }
}
