## SpringCloud

### Eureka

Eureka == 门诊, ZK, Consul, etcd: CAP; 或者: Eureka类似auguigu入住
的科技园，cloud-provider相当于阳哥，cloud-consumer相当于去找阳哥上课的我;
EurekaServer: Eureka; EurekaClient: cloud-provider, 而consumer作为
微服务，也是消费者，需要从registry获取可以消费的服务信息，所以也需要注册进Eureka,
也是EurekaClient; 所以也需要这个EurekaClient的依赖; 

![zk](/Users/xialei/Desktop/notes/e-d.png)

服务注册，发现都是靠registry，本质是KV键值对；存key这个服务名，
取value调用地址

问: 微服务RPC远程服务调用最核心的是什么？

答: HA. 注册中心一定要集群: Eureka注册中心集群, 实现 LB + FT; e.g. 
Eureka7001, 7002: 互相守望，相互调用
