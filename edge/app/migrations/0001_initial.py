# Generated by Django 3.0.3 on 2020-02-17 12:32

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Monitor',
            fields=[
                ('id', models.IntegerField(primary_key=True, serialize=False, verbose_name='id')),
                ('sensorId', models.IntegerField(default=0, max_length=150, verbose_name='传感器id')),
                ('responseDeviceList', models.CharField(default='', max_length=150, verbose_name='响应设备列表')),
                ('time', models.CharField(default='10', max_length=150, verbose_name='执行时间表达式')),
                ('emails', models.CharField(default='', max_length=150, verbose_name='邮件通知组')),
                ('sync_num', models.IntegerField(default=100, verbose_name='从边缘设备批量同步监控数据的条数')),
            ],
            options={
                'ordering': ['id'],
            },
        ),
        migrations.CreateModel(
            name='ResponseDevice',
            fields=[
                ('id', models.IntegerField(primary_key=True, serialize=False, verbose_name='id')),
                ('responseDeviceName', models.CharField(default='', max_length=150, verbose_name='响应外设类型名')),
                ('warehouseId', models.IntegerField(default=0, verbose_name='归属仓库id')),
                ('piId', models.IntegerField(default=0, verbose_name='树莓派id')),
                ('location', models.CharField(default='', max_length=150, verbose_name='响应外设坐标')),
                ('extension', models.CharField(default='', max_length=150, verbose_name='扩展字段')),
            ],
            options={
                'ordering': ['id'],
            },
        ),
        migrations.CreateModel(
            name='Sensor',
            fields=[
                ('id', models.IntegerField(primary_key=True, serialize=False, verbose_name='id')),
                ('sensorName', models.CharField(default='', max_length=150, verbose_name='传感器类型名')),
                ('warehouseId', models.IntegerField(default=0, verbose_name='归属仓库id')),
                ('piId', models.IntegerField(default=0, verbose_name='树莓派id')),
                ('location', models.CharField(default='', max_length=150, verbose_name='响应外设坐标')),
                ('extension', models.CharField(default='', max_length=150, verbose_name='扩展字段')),
            ],
            options={
                'ordering': ['id'],
            },
        ),
    ]