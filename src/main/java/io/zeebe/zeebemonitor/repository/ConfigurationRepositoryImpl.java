/*
 * Copyright © 2017 camunda services GmbH (info@camunda.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.zeebe.zeebemonitor.repository;

import java.util.Iterator;
import java.util.Optional;

import io.zeebe.zeebemonitor.entity.ConfigurationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationRepositoryImpl implements ConfigurationRepositoryCustom
{
    @Autowired
    private ConfigurationRepository repository;

    @Override
    public Optional<ConfigurationEntity> getConfiguration()
    {
        final Iterator<ConfigurationEntity> iterator = repository.findAll().iterator();

        if (iterator.hasNext())
        {
            return Optional.of(iterator.next());
        }
        else
        {
            return Optional.empty();
        }
    }

}
