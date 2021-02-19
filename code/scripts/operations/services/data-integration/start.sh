#!/bin/bash

echo
echo "---------------------------------------------------------------------------------"
echo "Entering operation-script"
echo "---------------------------------------------------------------------------------"
echo

echo
echo "Setting Up Resource Paths"
echo


# root/project/scripts/operations/services/data-integration
DATA_INTEGRATION_DIR="$(cd "$(dirname "$0")" && pwd)"

# root/project/scripts/operations/services
SERVICES_DIR="$(dirname "$DATA_INTEGRATION_DIR")"

# root/project/scripts/operations
OPERATIONS_DIR="$(dirname "$SERVICES_DIR")"

# root/project/scripts
SCRIPTS_DIR="$(dirname "$OPERATIONS_DIR")"

# root/project/
PROJECT_DIR="$(dirname "$SCRIPTS_DIR")"

echo
echo "Starting Operation"
echo


# Data Aggregator
# -------------------------------------------------------------------------------------
bash $PROJECT_DIR/library/data-aggregator/install.sh


# Data Saver
# -------------------------------------------------------------------------------------
bash $PROJECT_DIR/library/data-saver/install.sh


# Emissions Estimator
# -------------------------------------------------------------------------------------
bash $PROJECT_DIR/library/emissions-estimator/install.sh


# Kobo Collect Adapter
# -------------------------------------------------------------------------------------
bash $PROJECT_DIR/library/kobo-collect-adapter/install.sh


# Tasks Manager
# -------------------------------------------------------------------------------------
bash $PROJECT_DIR/library/tasks-manager/install.sh


echo
echo "---------------------------------------------------------------------------------"
echo "Leaving operation-script"
echo "---------------------------------------------------------------------------------"
echo
