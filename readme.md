### SpringCloud

1. Eureka == 门诊, ZK, Consul, etcd: CAP; 或者: Eureka类似auguigu入住
的科技园，cloud-provider相当于阳哥，cloud-consumer相当于去找阳哥上课的我;
EurekaServer: Eureka; EurekaClient: cloud-provider, 而consumer作为
微服务，也是消费者，需要从registry获取可以消费的服务信息，所以也需要注册进Eureka,
也是EurekaClient; 所以也需要这个EurekaClient的依赖

![zk](/Users/xialei/Desktop/notes/e-d.png)

