package com.code.scene.risk;

/**
 * @author huyuyang
 * @email yuyang.hu@opay-inc.com
 * @date 2019/10/31下午6:31
 */
public class RiskChainHandler<T> implements RiskChain<T> {


    @Override
    public RiskChain getData() {
        return this;
    }

    @Override
    public RiskChain filterData() {
        return this;
    }

    @Override
    public RiskChain executeRules() {
        return this;
    }

    @Override
    public RiskChain doActions() {
        return this;
    }

    @Override
    public T returnResult() {
        return null;
    }

}
