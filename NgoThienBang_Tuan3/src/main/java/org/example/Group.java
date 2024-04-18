package org.example;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Group {
    private final Set<String> fields = new HashSet();
    private final Set<String> methods = new HashSet();

    public Group() {
    }

    public Group addFields(String... var1) {
        String[] var2 = var1;
        int var3 = var1.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String var5 = var2[var4];
            this.fields.add(var5);
        }

        return this;
    }

    public Group addMethods(String... var1) {
        String[] var2 = var1;
        int var3 = var1.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String var5 = var2[var4];
            this.methods.add(var5);
        }

        return this;
    }

    public int fields() {
        return this.fields.size();
    }

    public int methods() {
        return this.methods.size();
    }

    public boolean intersects(Group var1) {
        Iterator var2 = var1.fields.iterator();

        String var3;
        do {
            if (!var2.hasNext()) {
                var2 = var1.methods.iterator();

                do {
                    if (!var2.hasNext()) {
                        return false;
                    }

                    var3 = (String)var2.next();
                } while(!this.methods.contains(var3));

                return true;
            }

            var3 = (String)var2.next();
        } while(!this.fields.contains(var3));

        return true;
    }

    public void merge(Group var1) {
        this.fields.addAll(var1.fields);
        this.methods.addAll(var1.methods);
    }

    public String toString() {
        String var10000 = String.valueOf(this.fields);
        return "Group{fields=" + var10000 + ", methods=" + String.valueOf(this.methods) + "}";
    }
}