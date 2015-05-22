function HashTable() {
           this._hashtable = {};
           if (typeof (_hashtable_initialized) == "undefined") {
               HashTable.prototype.put = function(key, value) {
                   if (key in this._hashtable) {
                       return false;
                   }
                   this._hashtable[key] = value;
                   return true;
               }
               HashTable.prototype.Remove = function(key) {
                   return delete (this._hashtable[key]);
               }
               HashTable.prototype.Count = function() {
                   var i = 0;
                   for (var k in this._hashtable)
                   { i++; }
                   return i;
               }
               HashTable.prototype.get = function(key) {
                   return this._hashtable[key];
               }
               HashTable.prototype.Clear = function() {
                   for (var k in this._hashtable)
                   { delete this._hashtable[k]; }
                   return true;
               }
               HashTable.prototype.containsKey = function(key) {
                   return typeof (this._hashtable[key]) != "undefined";
               }
               _hashtable_initialized = true;
           }
       }