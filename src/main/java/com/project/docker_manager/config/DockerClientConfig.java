package com.project.docker_manager.config;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DockerClientConfig {

    @Value("${docker.host}")
    private String dockerHost;

    @Value("${docker.tls.verify}")
    private boolean dockerTlsVerify;

    @Value("${docker.cert.path}")
    private String dockerCertPath;

    @Value("${docker.registry.user}")
    private String registryUser;

    @Value("${docker.registry.pass}")
    private String registryPass;

    @Value("${docker.registry.mail}")
    private String registryMail;

    @Value("${docker.registry.url}")
    private String registryUrl;

    @Bean
    public DockerClient buildDockerClient() {
        DefaultDockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
                .withDockerHost(dockerHost)
                .withDockerTlsVerify(dockerTlsVerify)
                .withDockerCertPath(dockerCertPath)
                .withRegistryUsername(registryUser)
                .withRegistryPassword(registryPass)
                .withRegistryEmail(registryMail)
                .withRegistryUrl(registryUrl)
                .build();

        ApacheDockerHttpClient dockerHttpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(config.getDockerHost()).build();

        return DockerClientBuilder.getInstance(config)
                .withDockerHttpClient(dockerHttpClient)
                .build();
    }
}

