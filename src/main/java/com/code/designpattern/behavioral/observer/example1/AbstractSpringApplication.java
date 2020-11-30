package com.code.designpattern.behavioral.observer.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020/10/29下午2:26
 */
public abstract class AbstractSpringApplication {

    protected List<SpringApplicationListener> springApplicationListenerList =new ArrayList<>();

    public abstract void attach(SpringApplicationListener springApplicationListener);

    public abstract void detach(SpringApplicationListener springApplicationListener);

    public abstract void notify(Object object);

}
