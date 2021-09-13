package com.autewifi.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * 定时任务配置
 * 
 * @author autewifi
 *
 */
@Configuration
public class ScheduleConfig
{
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource)
    {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setDataSource(dataSource);

        // quartz参数
        Properties prop = new Properties();
        prop.put("org.project.quartz.scheduler.instanceName", "RuoyiScheduler");
        prop.put("org.project.quartz.scheduler.instanceId", "AUTO");
        // 线程池配置
        prop.put("org.project.quartz.threadPool.class", "org.project.quartz.simpl.SimpleThreadPool");
        prop.put("org.project.quartz.threadPool.threadCount", "20");
        prop.put("org.project.quartz.threadPool.threadPriority", "5");
        // JobStore配置
        prop.put("org.project.quartz.jobStore.class", "org.project.quartz.impl.jdbcjobstore.JobStoreTX");
        // 集群配置
        prop.put("org.project.quartz.jobStore.isClustered", "true");
        prop.put("org.project.quartz.jobStore.clusterCheckinInterval", "15000");
        prop.put("org.project.quartz.jobStore.maxMisfiresToHandleAtATime", "1");
        prop.put("org.project.quartz.jobStore.txIsolationLevelSerializable", "true");

        // sqlserver 启用
        //prop.put("org.project.quartz.jobStore.selectWithLockSQL", "SELECT * FROM {0}LOCKS UPDLOCK WHERE LOCK_NAME = ?");
        prop.put("org.project.quartz.jobStore.misfireThreshold", "12000");
        prop.put("org.project.quartz.jobStore.tablePrefix", "QRTZ_");
        factory.setQuartzProperties(prop);

        factory.setSchedulerName("RuoyiScheduler");
        // 延时启动
        factory.setStartupDelay(1);
        factory.setApplicationContextSchedulerContextKey("applicationContextKey");
        // 可选，QuartzScheduler
        // 启动时更新己存在的Job，这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了
        factory.setOverwriteExistingJobs(true);
        // 设置自动启动，默认为true
        factory.setAutoStartup(true);

        return factory;
    }
}
