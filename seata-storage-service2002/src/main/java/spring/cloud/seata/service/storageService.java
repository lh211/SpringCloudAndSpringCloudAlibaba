package spring.cloud.seata.service;


public interface storageService {
    void decrease(Long productId,Integer count);
}
