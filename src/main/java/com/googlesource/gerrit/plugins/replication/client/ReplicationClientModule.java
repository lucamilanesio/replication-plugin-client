package com.googlesource.gerrit.plugins.replication.client;

import com.google.gerrit.extensions.registration.DynamicItem;
import com.google.inject.AbstractModule;
import com.googlesource.gerrit.plugins.replication.ReplicationPushFilter;

public class ReplicationClientModule extends AbstractModule {

  @Override
  protected void configure() {

    DynamicItem.bind(binder(), ReplicationPushFilter.class)
        .to(ReplicationDontPushMetaRefFilter.class);
  }
}
