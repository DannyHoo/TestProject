package com.code.scene.risk;

/**
 * @date 2019/10/31下午6:29
 */
public interface RiskChain<T> {

    RiskChain getData();

    RiskChain filterData();

    RiskChain executeRules();

    RiskChain doActions();

    T returnResult();
}
