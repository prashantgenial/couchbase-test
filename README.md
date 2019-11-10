# couchbase-test
Pre-requisit: Couchbase must be installed <br>
create a `test` bucket <br>
When running this application two sample customer will be created in `test` bucket. <br>
To get customer data run , http://localhost:8091/customer

### create a bucket
couchbase-cli bucket-create -c 127.0.0.1:8091 --username Administrator --password Password --bucket test --bucket-type couchbase --bucket-ramsize 1024

### list all buckets
couchbase-cli bucket-list -c 127.0.0.1:8091 --username Administrator --password Password

### export bucket data as a json file
cbexport json -c 127.0.0.1:8091 --username Administrator --password Password --bucket beer-sample -f list -o C:\prashant\beer-sample.json

### import into test-data bucket from json file
cbimport json -c 127.0.0.1:8091 --username Administrator --password Password --bucket test -f list -d file://C:/prashant/beer-sample.json -g key::#UUID# -t 4

### show test-data bucket detail using postman
http://127.0.0.1:8091/pools/default/buckets/test-data	[ using basic authentication ]

