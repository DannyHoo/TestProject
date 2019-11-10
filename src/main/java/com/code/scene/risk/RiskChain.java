package com.code.scene.risk;

/**
 * @author huyuyang
 * @email yuyang.hu@opay-inc.com
 * @date 2019/10/31下午6:29
 */
public interface RiskChain<T> {

    RiskChain getData();

    RiskChain filterData();

    RiskChain executeRules();

    RiskChain doActions();

    T returnResult();
}
