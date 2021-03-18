package com.example.wbdvsp2102danyinserverjava.controllers;

import com.example.wbdvsp2102danyinserverjava.models.Widget;
import com.example.wbdvsp2102danyinserverjava.services.WidgetService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    @Autowired
    WidgetService service;

    @PostMapping("/data/topics/{tid}/widgets")
    public Widget createWidgetForTopic(@PathVariable("tid") String topicId, @RequestBody Widget widget){
        return service.createWidgetForTopic(topicId, widget);
    }

    @GetMapping("/data/widgets")
    public List<Widget> findAllWidgets() {
      return service.findAllWidgets();
    }

    @GetMapping("/data/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(@PathVariable("tid") String topicId){
        return service.findWidgetsForTopic(topicId);
    }

    @DeleteMapping("/data/widgets/{wid}")
    public Integer deleteWidget(@PathVariable("wid") Long id) {
        return service.deleteWidget(id);
    }

    @PutMapping("/data/widgets/{wid}")
    public Integer updateWidget(
        @PathVariable("wid") Long id,
        @RequestBody Widget widget
    ){
        return service.updateWidget(id, widget);
    }
}
