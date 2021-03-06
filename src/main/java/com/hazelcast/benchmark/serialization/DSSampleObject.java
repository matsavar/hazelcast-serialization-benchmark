/*
 * Copyright (c) 2008-2013, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.benchmark.serialization;

import com.hazelcast.nio.IOUtil;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;

import java.io.IOException;

public class DSSampleObject extends SampleObject implements DataSerializable {

    public DSSampleObject() {
    }

    public DSSampleObject(int intVal) {
        super(intVal);
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeInt(intVal);
        out.writeShort(shortVal);
        out.writeFloat(floatVal);
        IOUtil.writeByteArray(out, byteArr);
        out.writeDoubleArray(dblArr);
        out.writeLongArray(longArr);
        out.writeUTF(str);
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        intVal = in.readInt();
        shortVal = in.readShort();
        floatVal = in.readFloat();
        byteArr = IOUtil.readByteArray(in);
        dblArr = in.readDoubleArray();
        longArr = in.readLongArray();
        str = in.readUTF();
    }
}
