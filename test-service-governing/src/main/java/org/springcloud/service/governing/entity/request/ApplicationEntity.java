package org.springcloud.service.governing.entity.request;

public class ApplicationEntity extends BaseParamEntity{

    private String serviceId;
    private String serviceName;
    private String serviceSecret;
    private String serviceRegistryUrl;
    private String serviceStatus;
    private String serviceDescription;
    private String teamMembers;
    private String teamIntroduction;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceSecret() {
        return serviceSecret;
    }

    public void setServiceSecret(String serviceSecret) {
        this.serviceSecret = serviceSecret;
    }

    public String getServiceRegistryUrl() {
        return serviceRegistryUrl;
    }

    public void setServiceRegistryUrl(String serviceRegistryUrl) {
        this.serviceRegistryUrl = serviceRegistryUrl;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public String getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(String teamMembers) {
        this.teamMembers = teamMembers;
    }

    public String getTeamIntroduction() {
        return teamIntroduction;
    }

    public void setTeamIntroduction(String teamIntroduction) {
        this.teamIntroduction = teamIntroduction;
    }

    @Override
    public String toString() {
        return "ApplicationEntity{" +
                "serviceId='" + serviceId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceSecret='" + serviceSecret + '\'' +
                ", serviceRegistryUrl='" + serviceRegistryUrl + '\'' +
                ", serviceStatus='" + serviceStatus + '\'' +
                ", serviceDescription='" + serviceDescription + '\'' +
                ", teamMembers='" + teamMembers + '\'' +
                ", teamIntroduction='" + teamIntroduction + '\'' +
                '}';
    }
}
