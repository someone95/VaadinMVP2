package georgi.vaadinmvp;

import javax.annotation.Resource;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

import georgi.vaadinmvp.student.StudentPresenter;

/**
 * @author Georgi Dinev
 */

@SpringUI
public class MyUi extends UI{


    @Resource
    private StudentPresenter presenter;

    @Override
    protected void init(final VaadinRequest vaadinRequest) {
        setContent(this.presenter.getView());
    }
}
