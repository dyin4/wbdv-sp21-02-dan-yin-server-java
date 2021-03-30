package com.example.wbdvsp2102danyinserverjava.services;


import com.example.wbdvsp2102danyinserverjava.models.Widget;
import com.example.wbdvsp2102danyinserverjava.repositories.WidgetRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository repository;

//  private List<Widget> widget = new ArrayList<Widget>();
//  {
//    Widget w1 = new Widget(123l, "ABC123", "HEADING", 1, "Widgets for topic ABC123");
//    Widget w2 = new Widget(234l, "ABC123", "PARAGRAPH", 1, "Lorem Ipsum");
//    Widget w3 = new Widget(345l, "ABC234", "HEADING", 2, "Widgets for topic ABC234");
//    Widget w4 = new Widget(456l, "ABC234", "PARAGRAPH", 1, "Welcome to Widget List");
//    Widget w5 = new Widget(567l, "ABC234", "PARAGRAPH", 1, "Welcome to Widget List");
//
//    widget.add(w1);
//    widget.add(w2);
//    widget.add(w3);
//    widget.add(w4);
//    widget.add(w5);
//  }
  public Widget createWidgetForTopic(String topicId, Widget widget){
    widget.setTopicId(topicId);
    return repository.save(widget);
//    widget.setId((new Date()).getTime());
//    this.widget.add(widget);
//    return widget;

  }

  public List<Widget> findAllWidgets() {
    return (List<Widget>) repository.findAll();
    //return widget;
  }

  public List<Widget> findWidgetsForTopic(String topicId){
    return repository.findWidgetsForTopic(topicId);
//    List<Widget> ws = new ArrayList<Widget>();
//    for(Widget w : widget){
//      if(w.getTopicId().equals(topicId)){
//        ws.add(w);
//      }
//    }
//    return ws;
  }

  public Widget findWidgetById(String id) {
    return repository.findWidgetById(id);
  }

  public Integer deleteWidget(Long id) {
    repository.deleteById(id);
    return 1;
  }

  public Integer updateWidget(Long id, Widget widget){
    Widget originalWidget = repository.findById(id).get();
    //TO DO COPY ALL FILED TESTING FOR NULL
    System.out.println("originalWidget");
    System.out.println(originalWidget);
    System.out.println(widget.getUrl());
    System.out.println("---------");
    originalWidget.setText(widget.getText());
    originalWidget.setType(widget.getType());
    originalWidget.setSize(widget.getSize());
    originalWidget.setUrl(widget.getUrl());
    originalWidget.setOrdered(widget.getOrdered());
    originalWidget.setHeight(widget.getHeight());
    originalWidget.setWidth(widget.getWidth());
    System.out.println(originalWidget.getOrdered());
    System.out.println(originalWidget.getUrl());

    repository.save(originalWidget);
    return 1;
//    for (int i = 0; i < this.widget.size(); i++) {t()
//      if (this.widget.get(i).getId().equals(id)) {
//        this.widget.set(i, widget);
//        return 1;
//      }
//    }
//    return -1;
  }
}
