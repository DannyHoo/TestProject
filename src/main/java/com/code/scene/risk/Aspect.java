package com.code.scene.risk;

/**
 * @date 2019/10/31下午6:32
 */
public class Aspect {

    public static void main(String[] args) {

    }

    public Object doRisk() {
        RiskChain riskChain = new RiskChainHandler();
        return riskChain.getData()
                .filterData()
                .executeRules()
                .doActions()
                .returnResult();
    }
}
