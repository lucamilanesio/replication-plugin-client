// Copyright (C) 2021 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.googlesource.gerrit.plugins.replication.client;

import com.google.common.flogger.FluentLogger;
import com.googlesource.gerrit.plugins.replication.ReplicationPushFilter;
import java.util.List;
import java.util.stream.Collectors;
import org.eclipse.jgit.transport.RemoteRefUpdate;

public class ReplicationDontPushMetaRefFilter implements ReplicationPushFilter {
  private static final FluentLogger logger = FluentLogger.forEnclosingClass();

  @Override
  public List<RemoteRefUpdate> filter(String projectName, List<RemoteRefUpdate> remoteUpdatesList) {
    logger.atInfo().log("Received the following refs to replicate: %s", remoteUpdatesList);
    List<RemoteRefUpdate> filteredRefs =
        remoteUpdatesList.stream()
            .filter(refUpdate -> !refUpdate.getSrcRef().endsWith("/meta"))
            .collect(Collectors.toList());
    logger.atInfo().log("Filtered refs to replicate: %s", filteredRefs);
    return filteredRefs;
  }
}
