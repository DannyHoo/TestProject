package com.code.designpattern.behavioral.observer.example1;

/**
 * @date 2020/10/29下午2:28
 */
public class SpringApplication extends AbstractSpringApplication {

    @Override
    public void attach(SpringApplicationListener springApplicationListener) {
        springApplicationListenerList.add(springApplicationListener);
    }

    @Override
    public void detach(SpringApplicationListener springApplicationListener) {
        springApplicationListenerList.remove(springApplicationListener);
    }

    @Override
    public void notify(Object object) {
        springApplicationListenerList.stream().forEach(springApplicationListener -> {
            springApplicationListener.listen(object);
        });
    }
}
