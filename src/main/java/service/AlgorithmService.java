package service;

import common.AlgorithmResultDS;
import common.DesireTO;

public interface AlgorithmService {

    void calculate();

    public AlgorithmResultDS calculateBasedOnIncoming(DesireTO desireTO);

}
