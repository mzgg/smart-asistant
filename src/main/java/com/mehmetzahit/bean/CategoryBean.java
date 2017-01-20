package com.mehmetzahit.bean;

import com.mehmetzahit.model.Category;
import com.mehmetzahit.persistence.dao.CategoryDAO;
import com.mehmetzahit.persistence.jpa.CategoryDAOImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GUNEY on 2.12.2016.
 */
@ManagedBean
@SessionScoped
public class CategoryBean {
    @Getter
    @Setter
    private List<String> a=new ArrayList<>();

    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    CategoryDAO categoryDAO = context.getBean(CategoryDAOImpl.class);

  CategoryDAO dao= (CategoryDAO) new Object();


    public  void list(long parent) {
        List<Category> categoryList = categoryDAO.categoryList(parent);

        if (categoryList.size() > 0)

            for (Category category : categoryList) {
                System.out.println("<ul><li>");
                System.out.println(category.getCategoryname());
                list(category.getCategoryId());
                System.out.print("</li></ul>");

            }

    }

    public void test(){
        list((long)0);
    }



    public static void main(String[] args) {
        long parent = 0;
        CategoryBean bean = new CategoryBean();
        bean.list(0);

    }
}
