package com.dolphin.springpost2.Domain;


import javax.persistence.*;

@Entity
public class CategoryItem {

    @Id @GeneratedValue
    @Column(name = "category_item_id")
    private Long id;
}
