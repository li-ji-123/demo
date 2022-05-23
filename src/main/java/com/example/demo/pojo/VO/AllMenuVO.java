package com.example.demo.pojo.VO;

import com.example.demo.entity.AllMenu;
import lombok.Data;

import java.util.List;

@Data
public class AllMenuVO {
   private List<AllMenu> mainMenu;
   private List<AllMenu> subMenu;
}
