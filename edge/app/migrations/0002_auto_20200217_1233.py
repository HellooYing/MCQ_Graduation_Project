# Generated by Django 3.0.3 on 2020-02-17 12:33

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('app', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='monitor',
            name='sensorId',
            field=models.IntegerField(default=0, verbose_name='传感器id'),
        ),
    ]