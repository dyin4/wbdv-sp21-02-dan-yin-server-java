package com.example.wbdvsp2102danyinserverjava.services;

import com.example.wbdvsp2102danyinserverjava.models.Widget;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {
  private List<Widget> widget = new ArrayList<Widget>();
  {
    Widget w1 = new Widget(123l, "ABC123", "HEADING", 1, "Widgets for topic ABC123");
    Widget w2 = new Widget(234l, "ABC123", "PARAGRAPH", 1, "Lorem Ipsum");
    Widget w3 = new Widget(345l, "ABC234", "HEADING", 2, "Widgets for topic ABC234");
    Widget w4 = new Widget(456l, "ABC234", "PARAGRAPH", 1, "Welcome to Widget List");
    Widget w5 = new Widget(567l, "ABC234", "PARAGRAPH", 1, "Welcome to Widget List");

    widget.add(w1);
    widget.add(w2);
    widget.add(w3);
    widget.add(w4);
    widget.add(w5);
  }
  public Widget createWidgetForTopic(String topicId, Widget widget){
    widget.setTopicId(topicId);
    widget.setId((new Date()).getTime());
    this.widget.add(widget);
    return widget;

  }

  public List<Widget> findAllWidgets() {
    return widget;
  }

  public List<Widget> findWidgetsForTopic(String topicId){
    List<Widget> ws = new ArrayList<Widget>();
    for(Widget w : widget){
      if(w.getTopicId().equals(topicId)){
        ws.add(w);
      }
    }
    return ws;
  }

  public Integer deleteWidget(Long id) {
    int index = -1;
    for (int i = 0; i < widget.size(); i++) {
      if (widget.get(i).getId().equals(id)) {
        index = i;
        widget.remove(index);
        return 1;
      }
    }

    return -1;
  }

  public Integer updateWidget(Long id, Widget widget){
    for (int i = 0; i < this.widget.size(); i++) {
      if (this.widget.get(i).getId().equals(id)) {
        this.widget.set(i, widget);
        return 1;
      }
    }
    return -1;
  }
}
