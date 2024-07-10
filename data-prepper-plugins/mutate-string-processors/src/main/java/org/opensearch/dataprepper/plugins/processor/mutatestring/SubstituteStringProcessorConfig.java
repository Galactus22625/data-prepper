/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.dataprepper.plugins.processor.mutatestring;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.opensearch.dataprepper.model.event.EventKey;

import java.util.List;

public class SubstituteStringProcessorConfig implements StringProcessorConfig<SubstituteStringProcessorConfig.Entry> {
    public static class Entry {
        private EventKey source;
        private String from;
        private String to;

        @JsonProperty("substitute_when")
        private String substituteWhen;

        public EventKey getSource() {
            return source;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public String getSubstituteWhen() { return substituteWhen; }

        public Entry(final EventKey source, final String from, final String to, final String substituteWhen) {
            this.source = source;
            this.from = from;
            this.to = to;
            this.substituteWhen = substituteWhen;
        }

        public Entry() {}
    }

    private List<Entry> entries;

    public List<Entry> getEntries() {
        return entries;
    }

    @Override
    public List<Entry> getIterativeConfig() {
        return entries;
    }
}
