package n_clustering

import n_clustering.Frontend.Add

object ClusterApp extends App{

  Frontend.initiate()
  Backend.initiate(2259)
  Backend.initiate(2560)
  Backend.initiate(2563)

  Thread.sleep(1000)

  Frontend.getFrontEnd ! Add(4,5)

  //Frontend: I will forward add operation to backend node to handle it.
  //I'm a backend with path Actor[akka://ClusterSystem/user/Backend#-2053991932] and I received add operation
  //I'm a backend with path Actor[akka://ClusterSystem/user/Backend#-643851655] and I received add operation
  //I'm a backend with path Actor[akka://ClusterSystem/user/Backend#2115986312] and I received add operation


//    [INFO] [02/21/2018 15:46:39.233] [main] [akka.remote.Remoting] Starting remoting
//  [INFO] [02/21/2018 15:46:39.404] [main] [akka.remote.Remoting] Remoting started; listening on addresses :[akka.tcp://ClusterSystem@127.0.0.1:2561]
//  [INFO] [02/21/2018 15:46:39.418] [main] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2561] - Starting up...
//  [INFO] [02/21/2018 15:46:39.522] [main] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2561] - Registered cluster JMX MBean [akka:type=Cluster]
//  [INFO] [02/21/2018 15:46:39.522] [main] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2561] - Started up successfully
//    [WARN] [02/21/2018 15:46:39.553] [ClusterSystem-akka.actor.default-dispatcher-2] [akka.tcp://ClusterSystem@127.0.0.1:2561/system/cluster/core/daemon/downingProvider] Don't use auto-down feature of Akka Cluster in production. See 'Auto-downing (DO NOT USE)' section of Akka Cluster documentation.
//    [INFO] [02/21/2018 15:46:39.564] [ClusterSystem-akka.actor.default-dispatcher-3] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2561] - Node [akka.tcp://ClusterSystem@127.0.0.1:2561] is JOINING, roles [frontend, dc-default]

  //    [INFO] [02/21/2018 15:46:39.568] [main] [akka.remote.Remoting] Starting remoting
//  [INFO] [02/21/2018 15:46:39.574] [main] [akka.remote.Remoting] Remoting started; listening on addresses :[akka.tcp://ClusterSystem@127.0.0.1:2259]
//  [INFO] [02/21/2018 15:46:39.575] [main] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2259] - Starting up...
//  [INFO] [02/21/2018 15:46:39.576] [ClusterSystem-akka.actor.default-dispatcher-3] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2561] - Leader is moving node [akka.tcp://ClusterSystem@127.0.0.1:2561] to [Up]
//    [WARN] [02/21/2018 15:46:39.579] [main] [akka.cluster.Cluster(akka://ClusterSystem)] Could not register Cluster JMX MBean with name=akka:type=Cluster as it is already registered. If you are running multiple clusters in the same JVM, set 'akka.cluster.jmx.multi-mbeans-in-same-jvm = on' in config
//  [INFO] [02/21/2018 15:46:39.579] [main] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2259] - Started up successfully
//    [WARN] [02/21/2018 15:46:39.581] [ClusterSystem-akka.actor.default-dispatcher-15] [akka.tcp://ClusterSystem@127.0.0.1:2259/system/cluster/core/daemon/downingProvider] Don't use auto-down feature of Akka Cluster in production. See 'Auto-downing (DO NOT USE)' section of Akka Cluster documentation.

  //    [INFO] [02/21/2018 15:46:39.602] [main] [akka.remote.Remoting] Starting remoting
//  [INFO] [02/21/2018 15:46:39.609] [main] [akka.remote.Remoting] Remoting started; listening on addresses :[akka.tcp://ClusterSystem@127.0.0.1:2560]
//  [INFO] [02/21/2018 15:46:39.610] [main] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2560] - Starting up...
//  [WARN] [02/21/2018 15:46:39.613] [main] [akka.cluster.Cluster(akka://ClusterSystem)] Could not register Cluster JMX MBean with name=akka:type=Cluster as it is already registered. If you are running multiple clusters in the same JVM, set 'akka.cluster.jmx.multi-mbeans-in-same-jvm = on' in config
//  [INFO] [02/21/2018 15:46:39.614] [main] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2560] - Started up successfully
//    [WARN] [02/21/2018 15:46:39.615] [ClusterSystem-akka.actor.default-dispatcher-3] [akka.tcp://ClusterSystem@127.0.0.1:2560/system/cluster/core/daemon/downingProvider] Don't use auto-down feature of Akka Cluster in production. See 'Auto-downing (DO NOT USE)' section of Akka Cluster documentation.

  //    [INFO] [02/21/2018 15:46:39.634] [main] [akka.remote.Remoting] Starting remoting
//  [INFO] [02/21/2018 15:46:39.639] [main] [akka.remote.Remoting] Remoting started; listening on addresses :[akka.tcp://ClusterSystem@127.0.0.1:2563]
//  [INFO] [02/21/2018 15:46:39.640] [main] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2563] - Starting up...
//  [WARN] [02/21/2018 15:46:39.644] [main] [akka.cluster.Cluster(akka://ClusterSystem)] Could not register Cluster JMX MBean with name=akka:type=Cluster as it is already registered. If you are running multiple clusters in the same JVM, set 'akka.cluster.jmx.multi-mbeans-in-same-jvm = on' in config
//  [INFO] [02/21/2018 15:46:39.645] [main] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2563] - Started up successfully
//    [WARN] [02/21/2018 15:46:39.647] [ClusterSystem-akka.actor.default-dispatcher-5] [akka.tcp://ClusterSystem@127.0.0.1:2563/system/cluster/core/daemon/downingProvider] Don't use auto-down feature of Akka Cluster in production. See 'Auto-downing (DO NOT USE)' section of Akka Cluster documentation.

  //    [INFO] [02/21/2018 15:46:39.709] [ClusterSystem-akka.actor.default-dispatcher-3] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2561] - Received InitJoin message from [Actor[akka.tcp://ClusterSystem@127.0.0.1:2259/system/cluster/core/daemon/joinSeedNodeProcess-1#1037713610]] to [akka.tcp://ClusterSystem@127.0.0.1:2561]
//  [INFO] [02/21/2018 15:46:39.709] [ClusterSystem-akka.actor.default-dispatcher-3] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2561] - Sending InitJoinAck message from node [akka.tcp://ClusterSystem@127.0.0.1:2561] to [Actor[akka.tcp://ClusterSystem@127.0.0.1:2259/system/cluster/core/daemon/joinSeedNodeProcess-1#1037713610]]
//  [INFO] [02/21/2018 15:46:39.709] [ClusterSystem-akka.actor.default-dispatcher-3] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2561] - Received InitJoin message from [Actor[akka.tcp://ClusterSystem@127.0.0.1:2560/system/cluster/core/daemon/joinSeedNodeProcess-1#1000250959]] to [akka.tcp://ClusterSystem@127.0.0.1:2561]
//  [INFO] [02/21/2018 15:46:39.709] [ClusterSystem-akka.actor.default-dispatcher-3] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2561] - Sending InitJoinAck message from node [akka.tcp://ClusterSystem@127.0.0.1:2561] to [Actor[akka.tcp://ClusterSystem@127.0.0.1:2560/system/cluster/core/daemon/joinSeedNodeProcess-1#1000250959]]
//  [INFO] [02/21/2018 15:46:39.709] [ClusterSystem-akka.actor.default-dispatcher-3] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2561] - Received InitJoin message from [Actor[akka.tcp://ClusterSystem@127.0.0.1:2563/system/cluster/core/daemon/joinSeedNodeProcess-1#835286497]] to [akka.tcp://ClusterSystem@127.0.0.1:2561]
//  [INFO] [02/21/2018 15:46:39.709] [ClusterSystem-akka.actor.default-dispatcher-3] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2561] - Sending InitJoinAck message from node [akka.tcp://ClusterSystem@127.0.0.1:2561] to [Actor[akka.tcp://ClusterSystem@127.0.0.1:2563/system/cluster/core/daemon/joinSeedNodeProcess-1#835286497]]

//  [INFO] [02/21/2018 15:46:39.726] [ClusterSystem-akka.actor.default-dispatcher-16] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2561] - Node [akka.tcp://ClusterSystem@127.0.0.1:2560] is JOINING, roles [backend, dc-default]
//    [INFO] [02/21/2018 15:46:39.726] [ClusterSystem-akka.actor.default-dispatcher-16] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2561] - Node [akka.tcp://ClusterSystem@127.0.0.1:2259] is JOINING, roles [backend, dc-default]
//    [INFO] [02/21/2018 15:46:39.727] [ClusterSystem-akka.actor.default-dispatcher-16] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2561] - Node [akka.tcp://ClusterSystem@127.0.0.1:2563] is JOINING, roles [backend, dc-default]

//    [INFO] [02/21/2018 15:46:39.797] [ClusterSystem-akka.actor.default-dispatcher-3] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2560] - Welcome from [akka.tcp://ClusterSystem@127.0.0.1:2561]
//  [INFO] [02/21/2018 15:46:39.797] [ClusterSystem-akka.actor.default-dispatcher-2] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2259] - Welcome from [akka.tcp://ClusterSystem@127.0.0.1:2561]
//  [INFO] [02/21/2018 15:46:39.797] [ClusterSystem-akka.actor.default-dispatcher-2] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2563] - Welcome from [akka.tcp://ClusterSystem@127.0.0.1:2561]

//  [WARN] [SECURITY][02/21/2018 15:46:39.804] [ClusterSystem-akka.remote.default-remote-dispatcher-20] [akka.serialization.Serialization(akka://ClusterSystem)] Using the default Java serializer for class [n_clustering.Backend$BackendRegistration$] which is not recommended because of performance implications. Use another serializer or disable this warning using the setting 'akka.actor.warn-about-java-serializer-usage'
//  [WARN] [SECURITY][02/21/2018 15:46:39.804] [ClusterSystem-akka.remote.default-remote-dispatcher-9] [akka.serialization.Serialization(akka://ClusterSystem)] Using the default Java serializer for class [n_clustering.Backend$BackendRegistration$] which is not recommended because of performance implications. Use another serializer or disable this warning using the setting 'akka.actor.warn-about-java-serializer-usage'
//  [WARN] [SECURITY][02/21/2018 15:46:39.804] [ClusterSystem-akka.remote.default-remote-dispatcher-21] [akka.serialization.Serialization(akka://ClusterSystem)] Using the default Java serializer for class [n_clustering.Backend$BackendRegistration$] which is not recommended because of performance implications. Use another serializer or disable this warning using the setting 'akka.actor.warn-about-java-serializer-usage'

  //  [INFO] [02/21/2018 15:46:40.565] [ClusterSystem-akka.actor.default-dispatcher-16] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2561] - Leader is moving node [akka.tcp://ClusterSystem@127.0.0.1:2259] to [Up]
//    [INFO] [02/21/2018 15:46:40.565] [ClusterSystem-akka.actor.default-dispatcher-16] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2561] - Leader is moving node [akka.tcp://ClusterSystem@127.0.0.1:2560] to [Up]
//    [INFO] [02/21/2018 15:46:40.565] [ClusterSystem-akka.actor.default-dispatcher-16] [akka.cluster.Cluster(akka://ClusterSystem)] Cluster Node [akka.tcp://ClusterSystem@127.0.0.1:2561] - Leader is moving node [akka.tcp://ClusterSystem@127.0.0.1:2563] to [Up]


}
