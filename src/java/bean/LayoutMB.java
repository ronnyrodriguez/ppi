/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;

/**
 * Created by rmpestano on 07/05/17.
 */
@Named
@SessionScoped
public class LayoutMB implements Serializable {

    private String layout;

    @PostConstruct
    public void init() {
        setDefaultLayout();
    }

    public String getLayout() {
        return layout;
    }

    public void setHorizontalLayout() {
        layout = "/WEB-INF/templates/template-top.xhtml";
    }

    public void setDefaultLayout() {
        layout = "/WEB-INF/templates/template.xhtml";
    }
}
